package com.pedrovega.operationquasarmlb.exception;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    DISTANCE_CANNOT_BE_NULL("El valor de la distacia no puede ser nulo"),
    MESSAGE_CANNOT_BE_NULL("El contenido de la mensaje no puede ser nulo"),
    INVALID_SATELLITE("El nombre del satélite enviado no es valido, solo se conocen los satelites kenobi, skywalker y sato"),
    MISSING_SATELLITE("Falta información de algunos de los satelites kenobi, skywalker o sato");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
