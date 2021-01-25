package com.pedrovega.operationquasarmlb.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private Float x;
    private Float y;

    public Position(Float x, Float y) {
        this.x = x;
        this.y = y;
    }
}
