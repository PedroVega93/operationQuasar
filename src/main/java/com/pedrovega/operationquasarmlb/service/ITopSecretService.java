package com.pedrovega.operationquasarmlb.service;

import com.pedrovega.operationquasarmlb.domain.SatelliteData;
import com.pedrovega.operationquasarmlb.dto.TopSecretRequestDTO;
import com.pedrovega.operationquasarmlb.dto.TopSecretResponseDTO;

public interface ITopSecretService {

    TopSecretResponseDTO topsecret(TopSecretRequestDTO topSecretRequestDTO);

    void topsecretSlipt(SatelliteData satelliteData, String satelliteName);

    TopSecretResponseDTO getTopsecretSlipt();
}
