package com.soagile.api.common.web;

import com.soagile.api.common.web.exception.ApiError;
import com.soagile.api.common.web.exception.MyBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by soagile-pc on 13/09/2016.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        LOGGER.info("Bad Request: {}", ex.getMessage());
        LOGGER.debug("Bad Request: ", ex);
        final ApiError apiError = message(HttpStatus.BAD_REQUEST, ex);

        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    private ApiError message(final HttpStatus status, final Exception ex) {

        final String devMessage = ex.getClass().getSimpleName();
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
        return new ApiError(status.value(), message, devMessage);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler ( value = {DataIntegrityViolationException.class, MyBadRequestException.class})
    public final ResponseEntity<Object> handleBadRequest(final RuntimeException ex, final WebRequest request) {
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST,ex), new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }


}
