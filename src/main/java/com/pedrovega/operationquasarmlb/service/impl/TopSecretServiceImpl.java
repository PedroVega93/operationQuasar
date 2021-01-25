package com.pedrovega.operationquasarmlb.service.impl;

import com.pedrovega.operationquasarmlb.configuration.SatellitePositionsProperties;
import com.pedrovega.operationquasarmlb.db.entity.Satellites;
import com.pedrovega.operationquasarmlb.db.repository.SatellitesRepository;
import com.pedrovega.operationquasarmlb.domain.SatelliteData;
import com.pedrovega.operationquasarmlb.domain.SatellitesInformation;
import com.pedrovega.operationquasarmlb.dto.TopSecretRequestDTO;
import com.pedrovega.operationquasarmlb.dto.TopSecretResponseDTO;
import com.pedrovega.operationquasarmlb.exception.ErrorMessages;
import com.pedrovega.operationquasarmlb.exception.IndeterminateException;
import com.pedrovega.operationquasarmlb.service.ITopSecretService;
import com.pedrovega.operationquasarmlb.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TopSecretServiceImpl implements ITopSecretService {

    @Autowired
    private SatellitePositionsProperties satellitePositions;

    @Autowired
    private SatellitesRepository satellitesRepository;

    @Override
    public TopSecretResponseDTO topsecret(TopSecretRequestDTO topSecretRequestDTO) {

        SatellitesInformation satellitesInformation = Util.getListOfSatellites(topSecretRequestDTO.getSatellites(), null, topSecretRequestDTO.getSatellites().size(), satellitePositions);

        return new TopSecretResponseDTO(Util.getPosition(satellitesInformation.getCoordinatesX(), satellitesInformation.getCoordinatesY(), satellitesInformation.getDistancesSatellite()), Util.getMessage(satellitesInformation.getMessagesSatellites()).trim());
    }

    @Override
    public void topsecretSlipt(SatelliteData satelliteData, String satelliteName) {

        satellitePositions.validatePosition(satelliteName, 0);
        Util.saveOrUpdateSatellite(satelliteName, new Satellites(satelliteName, satelliteData.getDistance(), String.join(",", satelliteData.getMessage())), satellitesRepository);
    }

    @Override
    public TopSecretResponseDTO getTopsecretSlipt() {

        List<Satellites> existingSatellites = satellitesRepository.findAllTransactions();

        if (existingSatellites.size() < 3)
            throw new IndeterminateException(ErrorMessages.MISSING_SATELLITE.getMessage());

        SatellitesInformation satellitesInformation = Util.getListOfSatellites(null, existingSatellites, existingSatellites.size(), satellitePositions);
        return new TopSecretResponseDTO(Util.getPosition(satellitesInformation.getCoordinatesX(), satellitesInformation.getCoordinatesY(), satellitesInformation.getDistancesSatellite()), Util.getMessage(satellitesInformation.getMessagesSatellites()).trim());
    }

}
