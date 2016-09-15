package com.soagile.api.common.web.exception;

/**
 * Created by BMGTS on 23/03/2016.
 */

public class MyResourceNotFoundException extends RuntimeException
{

    public MyResourceNotFoundException() {
        super();
    }

    public MyResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyResourceNotFoundException(final String message) {
        super(message);
    }

    public MyResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
