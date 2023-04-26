package com.flexone.fishing_db.controllers.advice;

import com.flexone.fishing_db.errors.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleBadRequestExceptions(RuntimeException ex, WebRequest request) {
        ApiError apiError = createApiError(HttpStatus.BAD_REQUEST, ex, request);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNotFoundExceptions(NoSuchElementException ex, WebRequest request) {
        ApiError apiError = createApiError(HttpStatus.NOT_FOUND, ex, request);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ApiError apiError = createApiError(HttpStatus.BAD_REQUEST, ex, request);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        ApiError apiError = createApiError(HttpStatus.BAD_REQUEST, ex, request);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllUnhandledExceptions(Exception ex, WebRequest request) {
        ApiError apiError = createApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex, request);
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiError createApiError(HttpStatus status, Exception ex, WebRequest request) {
        return new ApiError(LocalDateTime.now(), status.value(), status.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
    }

}
