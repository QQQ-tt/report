package com.fry.report.config.security;

import com.fry.report.common.CommonMethod;
import com.fry.report.common.enums.DataEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Component
@Slf4j
public class DiyAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private CommonMethod commonMethod;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("user info error {}", DataEnums.ACCESS_DENIED);
        commonMethod.failed(response, DataEnums.ACCESS_DENIED);
    }
}
