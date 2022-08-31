package com.fry.report.common.exception;

import com.fry.report.common.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * <p>方法顺序及捕获顺序</p>
 * @author qtx
 * @Since: 2022/8/31
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DateException.class)
    public ResultObject<String> dateException(DateException e){
        log.info(e.getMessage());
        return ResultObject.failed(e.getMessage(),e.getCode());
    }
}