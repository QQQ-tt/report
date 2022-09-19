package com.fry.report.common;

import com.alibaba.fastjson.JSONArray;
import com.fry.report.common.enums.DataEnums;
import com.fry.report.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author QTX
 * @since 2022/8/31
 */
@Component
public class CommonMethod {

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 过滤器返回信息
     *
     * @param response  response
     * @param dataEnums 错误信息
     * @throws IOException
     */
    public void failed(HttpServletResponse response, DataEnums dataEnums) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //设置响应状态码
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //输入响应内容
        PrintWriter writer = response.getWriter();
        String s = JSONArray.toJSON(ResultObject.failed(dataEnums)).toString();
        writer.write(s);
        writer.flush();
    }

    /**
     * 获取user
     *
     * @return
     */
    public User getUser() {
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            user = (User) principal;
        }
        return user;
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public String getName() {
        User user = getUser();
        return user != null ? jwtUtils.TOKEN.get(user.getUsername()).getName() : "admin";
    }
}
