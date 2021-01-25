package com.pedrovega.operationquasarmlb.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IndeterminateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorMessage;

    public IndeterminateException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
