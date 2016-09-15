package com.soagile.api.common.web.exception;

/**
 * Created by soagile-pc on 10/08/2016.
 */
public class MyConflictException extends RuntimeException{
    public MyConflictException(final String message) {
        super(message);
    }

    public MyConflictException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyConflictException(final Throwable cause) {
        super(cause);
    }

    public MyConflictException() {
    }
}
