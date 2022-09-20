package com.qtx.report.common;

import com.qtx.report.common.enums.DataEnums;
import com.qtx.report.common.enums.ResultCode;
import lombok.Data;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
@Data
public class ResultObject<T> {
    private String msg;
    private int code;
    private T data;

    private ResultObject(T data) {
        this.data = data;
    }

    private ResultObject(int code) {
        this.code = code;
    }

    private ResultObject(String msg) {
        this.msg = msg;
    }

    private ResultObject(DataEnums dataEnums) {
        this.code = dataEnums.getCode();
        this.msg = dataEnums.getMsg();
    }

    private ResultObject(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultObject(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    private ResultObject(T data, ResultCode resultCode) {
        this.data = data;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static <T> ResultObject<T> success(T date) {
        return new ResultObject<>(date, ResultCode.SUCCESS);
    }

    public static <T> ResultObject<T> failed(int code) {
        return new ResultObject<>(code);
    }

    public static <T> ResultObject<T> failed(String msg) {
        return new ResultObject<>(msg);
    }

    public static <T> ResultObject<T> failed(String msg, int code) {
        return new ResultObject<>(code, msg);
    }

    public static <T> ResultObject<T> failed(DataEnums dataEnums) {
        return new ResultObject<>(dataEnums);
    }
}
