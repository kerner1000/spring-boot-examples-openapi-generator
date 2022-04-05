package com.github.kerner1000.spring.boot.examples.openapi;

import org.openapitools.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ErrorHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Error> handleConflict(
            Exception ex, WebRequest request) {
        return ResponseEntity.of(Optional.of(new Error().errorCode(111).message(ex.getMessage())));
    }
}