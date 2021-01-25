package com.pedrovega.operationquasarmlb.dto;

import com.pedrovega.operationquasarmlb.domain.Satellite;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@ApiModel
public class TopSecretRequestDTO {

    @Valid
    private List< @Valid Satellite> satellites;

}
