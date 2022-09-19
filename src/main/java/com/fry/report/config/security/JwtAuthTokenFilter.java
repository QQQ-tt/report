package com.fry.report.config.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fry.report.common.CommonMethod;
import com.fry.report.common.enums.DataEnums;
import com.fry.report.common.pojo.Token;
import com.fry.report.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
@Component
@Slf4j
public class JwtAuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CommonMethod commonMethod;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("token :{}", token);
        String card = jwtUtils.getInfoFromToken(token);
        if (card == null) {
            log.info("token info error {}", DataEnums.USER_IS_FAIL);
            commonMethod.failed(response, DataEnums.USER_IS_FAIL);
            return;
        }
        log.info("card :{}", card);
        // 验证token
        log.info("token map :{}", jwtUtils.TOKEN);
        Token s = jwtUtils.TOKEN.get(card);
        if (Objects.isNull(s)) {
            log.info("token info error {}", DataEnums.USER_NOT_LOGIN);
            commonMethod.failed(response, DataEnums.USER_NOT_LOGIN);
            return;
        }
        // 判断是否过期
        if (jwtUtils.isTokenExpired(s.getToken())) {
            jwtUtils.TOKEN.remove(card);
            log.info("token info error {}", DataEnums.USER_LOGIN_EXPIRED);
            commonMethod.failed(response, DataEnums.USER_LOGIN_EXPIRED);
            return;
        }
        // 获取安全上下文
        SecurityContext context = SecurityContextHolder.getContext();
        // 赋予权限
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(s.getUser(),
                null,
                s.getUser().getAuthorities());
        context.setAuthentication(authenticationToken);
        SecurityContextHolder.setContext(context);
        // 放行
        filterChain.doFilter(request, response);
    }
}
