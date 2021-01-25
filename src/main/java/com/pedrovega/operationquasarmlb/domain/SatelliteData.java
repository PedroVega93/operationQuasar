package com.pedrovega.operationquasarmlb.domain;

import com.pedrovega.operationquasarmlb.exception.ErrorMessages;
import com.pedrovega.operationquasarmlb.exception.IndeterminateException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@ApiModel
public class SatelliteData {

    @NotNull(message = "el valor de la distaciona no puede ser nulo")
    @ApiModelProperty(value = "Distancia del satélite al emisor", required = true)
    private Float distance;

    @NotNull(message = "el valor de la mensaje no puede ser nulo")
    @ApiModelProperty(value = "mensaje recibido por el satélite", required = true)
    private List<String> message;

    public Float getDistance() {
        if (distance==null)
            throw new IndeterminateException(ErrorMessages.DISTANCE_CANNOT_BE_NULL.getMessage());

        return distance;
    }

    public List<String> getMessage() {
        if (message==null)
            throw new IndeterminateException(ErrorMessages.MESSAGE_CANNOT_BE_NULL.getMessage());

        return message;
    }
}
