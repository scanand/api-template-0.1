package com.soagile.api.common.web;

import com.soagile.api.common.persistence.model.IEntity;
import com.soagile.api.common.web.exception.MyBadRequestException;
import com.soagile.api.common.web.exception.MyConflictException;
import com.soagile.api.common.web.exception.MyResourceNotFoundException;

/**
 * Created by BMGTS on 23/03/2016.
 */
public final class RestPreconditions {

    public RestPreconditions() {
        throw new AssertionError();
    }

    /**
     * <T> in method declaration that signifies method uses generic type T
     * T indicates generic type T is return type
     * [final T reference] indicates *reference* is of generic type T
     **/
    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new MyResourceNotFoundException();
        }
        return reference;
    }

    /**
     * @param reference
     * @param <T>
     */
    public static <T extends IEntity> T checkRequestElementNotNull(final  T reference)   {
        return checkRequestElementNotNull(reference,null);

    }

    public static <T extends IEntity> T checkRequestElementNotNull(final T reference, final String message)  {
        if( null == reference ) {
            throw new MyBadRequestException(message);
        }
        return reference;
    }

    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    public  static void checkRequestState(final boolean expression, final String message) {
        if( !expression) {
            throw new MyConflictException(message);
        }
    }

    public static void checkIfBadRequest(final boolean b) {
        checkIfBadRequest(b, null);
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws MyBadRequestException
     *             if {@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression, final String message) {
        if (!expression) {
            throw new MyBadRequestException(message);
        }
    }

}

