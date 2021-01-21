package com.pedrovega.operationquasarmlb.dto;

import com.pedrovega.operationquasarmlb.domain.Satellite;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopSecretRequestDTO {

    private List<Satellite> satellites;
}
