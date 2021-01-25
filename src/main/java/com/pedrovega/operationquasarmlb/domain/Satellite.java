package com.pedrovega.operationquasarmlb.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class Satellite extends SatelliteData {

    @NotEmpty(message = "Nombre del satelite no puede ser nulo")
    @ApiModelProperty(value = "Nombre del satélite: kenobi, skywalker o sato", required = true)
    private String name;
}
