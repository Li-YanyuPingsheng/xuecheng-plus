package com.xuecheng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-03-02 20:08
 * @Description 功能描述
 */
@ControllerAdvice
public class GlobeExceptionHandler {

    @ResponseBody
    @ExceptionHandler(XueChengPlusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse doXueChengPlusException(XueChengPlusException e) {
        String errMessage = e.getErrMessage();

        return new RestErrorResponse(errMessage);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse doException(Exception e) {
        e.printStackTrace();

        return new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse doException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldError = bindingResult.getFieldErrors();
        StringBuffer stringBuffer = new StringBuffer();
        fieldError.forEach(error -> {
            stringBuffer.append(error.getDefaultMessage()).append(",");
        });

        return new RestErrorResponse(stringBuffer.toString());
    }

}
