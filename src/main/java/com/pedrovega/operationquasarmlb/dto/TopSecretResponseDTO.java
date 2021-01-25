package com.pedrovega.operationquasarmlb.dto;

import com.pedrovega.operationquasarmlb.domain.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopSecretResponseDTO {
    private Position position;
    private String message;

    public TopSecretResponseDTO(Position position, String message) {
        this.position = position;
        this.message = message;
    }
}
