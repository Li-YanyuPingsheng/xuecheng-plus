package com.xuecheng.exception;

/**
 * @Author LiMingYu
 * @Create 2023-03-02 20:00
 * @Description 功能描述
 */
public class XueChengPlusException extends RuntimeException{

    private String errMessage;

    public XueChengPlusException() {
        super();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public XueChengPlusException(String message) {
        super(message);
        this.errMessage = message;
    }

    public static void cast(String errMessage) {
        throw new XueChengPlusException(errMessage);
    }

    public static void cast(CommonError commonError) {
        throw new XueChengPlusException(commonError.getErrMessage());
    }
}
