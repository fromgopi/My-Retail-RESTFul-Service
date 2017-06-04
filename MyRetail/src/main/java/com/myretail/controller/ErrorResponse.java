package com.myretail.controller;

/**
 * This is the error response class which has the error code and message.
 * @author Muktevi
 *
 */
public class ErrorResponse {

    private int errorCode;
    private String message;
    
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
