package com.pedrovega.operationquasarmlb.service;

import com.pedrovega.operationquasarmlb.dto.TopSecretRequestDTO;
import com.pedrovega.operationquasarmlb.dto.TopSecretResponseDTO;

public interface ITopSecretService {

    public TopSecretResponseDTO topsecret(TopSecretRequestDTO topSecretRequestDTO);
}
