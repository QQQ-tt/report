package com.qtx.report.common.enums;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS("成功",200),
    /**
     * 失败
     */
    FAILED("失败",201);

    private String msg;
    private int code;

    ResultCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
