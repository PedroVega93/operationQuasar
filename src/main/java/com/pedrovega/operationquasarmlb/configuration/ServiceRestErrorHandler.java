package com.pedrovega.operationquasarmlb.configuration;

import com.pedrovega.operationquasarmlb.exception.IndeterminateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.pedrovega.operationquasarmlb")
public class ServiceRestErrorHandler {

    @ExceptionHandler(IndeterminateException.class)
    public ResponseEntity<String> exception(IndeterminateException indeterminateException){
        return new ResponseEntity<>(indeterminateException.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
}
