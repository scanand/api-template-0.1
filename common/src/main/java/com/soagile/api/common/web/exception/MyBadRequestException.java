package com.soagile.api.common.web.exception;

/**
 * Created by soagile-pc on 10/08/2016.
 */
public class MyBadRequestException extends RuntimeException {
    public MyBadRequestException() {
    }

    public MyBadRequestException(String message) {
        super(message);
    }

    public MyBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyBadRequestException(Throwable cause) {
        super(cause);
    }

}
