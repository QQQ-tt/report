package com.qtx.report.common.exception;

import com.qtx.report.common.enums.DataEnums;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
public class DateException extends Exception{

    private final int code;

    public DateException(DataEnums dataEnums){
        super(dataEnums.toString());
        this.code = dataEnums.getCode();
    }

    public int getCode() {
        return code;
    }
}
