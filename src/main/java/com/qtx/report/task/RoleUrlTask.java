package com.qtx.report.task;


import com.qtx.report.pojo.bo.RoleUrlBo;
import com.qtx.report.service.impl.SysRoleUrlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
    /**
     * 配置类写好管理员角色名称
     */
    @Value("${role.admin}")
    private String roleAdmin;

    @Autowired
    private SysRoleUrlServiceImpl sysRoleUrlService;

    private Map<String, Set<String>> roleUrl;

    @PostConstruct
    @Scheduled(cron = "0 */5 * * * ?")
    private void setRoleUrl() {
        log.info("初始化用户权限开始。");
        roleUrl = null;
        List<RoleUrlBo> roleUrlAll = sysRoleUrlService.getRoleUrlAll();
        roleUrl = roleUrlAll.stream()
                .collect(Collectors.groupingBy(RoleUrlBo::getRoleName, mapping(RoleUrlBo::getUrl, toSet())));
        log.info("初始化用户权限结束。");
    }

    public boolean getAuth(Collection<? extends GrantedAuthority> roleList, String url) {
        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicBoolean admin = new AtomicBoolean(false);
        roleList.forEach(e -> {
            if (roleAdmin.equals(e.getAuthority()) && !admin.get()) {
                admin.set(true);
            }
            if (roleUrl.containsKey(e.getAuthority()) && !flag.get()) {
                // /report/invoiceRecords/remove/{id} 此类还无法校验
                // 没想到解决方案，决定放弃 @PathVariable 此注解
                flag.set(roleUrl.get(e.getAuthority()).contains(url));
            }
        });
        return flag.get() || admin.get();
    }
}
