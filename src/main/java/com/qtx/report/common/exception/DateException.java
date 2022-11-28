package com.qtx.report.common.exception;

import com.qtx.report.common.enums.DataEnums;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
public class DateException extends RuntimeException {

    private final int code;

    private final String msg;

    public DateException(DataEnums dataEnums) {
        super(dataEnums.toString());
        this.code = dataEnums.getCode();
        this.msg = dataEnums.getMsg();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DateException{" + "code=" + code + ", msg='" + msg + '}';
    }
}
