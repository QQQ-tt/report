package com.fry.report.common;

import com.alibaba.fastjson.JSONArray;
import com.fry.report.common.enums.DataEnums;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
public class CommonMethod {

    /**
     * 过滤器返回信息
     * @param response response
     * @param dataEnums 错误信息
     * @throws IOException
     */
    public static void failed(HttpServletResponse response, DataEnums dataEnums) throws IOException {
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
     * 获取用户名
     * @return 用户名
     */
    public static String getName() {
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            user = (User) principal;
        }
        return user != null ? user.getUsername() : "admin";
    }
}
