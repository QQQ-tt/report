package com.fry.report.task;

import com.fry.report.pojo.dto.RoleUrlDto;
import com.fry.report.service.impl.SysRoleUrlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

/**
 * @author qtx
 * @date 2022/9/13 21:36
 */
@Slf4j
@Component
public class RoleUrlTask {

    @Autowired
    private SysRoleUrlServiceImpl sysRoleUrlService;

    private Map<String, Set<String>> roleUrl;

    @Scheduled(cron = "0 */5 * * * ?")
    private void setRoleUrl() {
        roleUrl = null;
        List<RoleUrlDto> roleUrlAll = sysRoleUrlService.getRoleUrlAll();
        roleUrl = roleUrlAll.stream()
                .collect(Collectors.groupingBy(RoleUrlDto::getRole, mapping(RoleUrlDto::getUrl, toSet())));
    }

    public boolean getAuth(Collection<? extends GrantedAuthority> roleList, String url) {
        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicBoolean admin = new AtomicBoolean(false);
        roleList.forEach(e -> {
            if ("admin".equals(e.getAuthority()) && !admin.get()){
                flag.set(true);
            }
            flag.set(roleUrl.get(e.getAuthority()).contains(url));
        });
        return flag.get() || admin.get();
    }
}
