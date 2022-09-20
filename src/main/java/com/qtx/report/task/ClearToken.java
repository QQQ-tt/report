package com.qtx.report.task;

import com.qtx.report.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qtx
 * @date 2022/9/10 16:20
 */
@Slf4j
public class ClearToken {

    @Autowired
    private JwtUtils jwtUtils;

    @Scheduled(cron = "0 0 * * * ? *")
    private void clearToken() {
        List<String> list = new ArrayList<>();
        jwtUtils.TOKEN.forEach(((s, token) -> {
            if (jwtUtils.isTokenExpired(token.getToken())) {
                list.add(s);
            }
        }));
        list.forEach(e -> jwtUtils.TOKEN.remove(e));
        log.info("清理过期token数量：{}", list.size());
    }
}
