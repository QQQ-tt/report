package com.qtx.report.config.security;

import com.qtx.report.common.CommonMethod;
import com.qtx.report.common.enums.DataEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
public class DiyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private CommonMethod commonMethod;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.info("user info error {}", DataEnums.ACCESS_DENIED);
        commonMethod.failed(response, DataEnums.ACCESS_DENIED);
    }
}
