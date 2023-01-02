package com.msag.securityinfo.common.exception;

public class UnknownCategoryException extends Exception{
    public UnknownCategoryException(String message) {
        super(message);
    }

    public UnknownCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
