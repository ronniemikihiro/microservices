package com.example.rest.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleNegocioException(Exception ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final ApiError apiError = ApiError.builder()
                .timestamp(System.currentTimeMillis())
                .status(status.value())
                .error(ex.getMessage())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(apiError);
    }
}
