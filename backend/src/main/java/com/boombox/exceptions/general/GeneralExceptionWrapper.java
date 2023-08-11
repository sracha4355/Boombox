package com.boombox.exceptions.general;

import org.springframework.http.HttpStatus;

public class GeneralExceptionWrapper {
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;

    public GeneralExceptionWrapper(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
