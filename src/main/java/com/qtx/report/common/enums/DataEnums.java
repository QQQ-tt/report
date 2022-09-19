package com.qtx.report.common.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
public enum DataEnums {
    /**
     * 密码错误
     */
    WRONG_PASSWORD("密码错误", 201),
    /**
     * 无法访问
     */
    ACCESS_DENIED("无法访问", 403),
    /**
     * 登录已过期
     */
    USER_LOGIN_EXPIRED("登录已过期", 201),
    /**
     * 用户未登录
     */
    USER_NOT_LOGIN("用户未登录", 201),
    /**
     * 用户验证失败
     */
    USER_IS_FAIL("用户验证失败", 201),
    /**
     * 入参数据为空.
     */
    DATA_IS_NULL("入参数据为空.", 201),
    /**
     * 结果集为空.
     */
    DATA_RESULT_Null("结果集为空.", 202),
    /**
     * 数据插入失败
     */
    DATA_INSERT_FAIL("数据插入失败", 203);
    /**
     * 提示
     */
    private final String msg;
    /**
     * 错误编码
     */
    private final int code;

    DataEnums(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private static final Map<String, Integer> DATE_ENUMS = new HashMap<>();

    static {
        Stream.of(DataEnums.values()).forEach(v -> DATE_ENUMS.put(v.msg, v.code));
    }

}
