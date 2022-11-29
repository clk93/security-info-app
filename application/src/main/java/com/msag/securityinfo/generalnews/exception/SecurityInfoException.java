package com.msag.securityinfo.generalnews.exception;

public class SecurityInfoException extends Exception{

    public SecurityInfoException(String message) {
        super(message);
    }

    public SecurityInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
