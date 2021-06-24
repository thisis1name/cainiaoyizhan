package com.neuedu.his.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {


    @ExceptionHandler
    public com.neuedu.his.util.CommonResult exceptionHandler(HttpServletRequest request, Exception ex) {
        ex.printStackTrace();
        if(ex instanceof NoHandlerFoundException) {
            return com.neuedu.his.util.CommonResult.nohandler();
        }
        return CommonResult.failed(ex.getMessage());
    }


}