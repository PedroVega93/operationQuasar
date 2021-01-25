package com.pedrovega.operationquasarmlb.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SatellitesInformation {

    List<Float> coordinatesX;
    List<Float> coordinatesY;
    List<Float> distancesSatellite;
    List<List<String>> messagesSatellites;

    public SatellitesInformation(List<Float> coordinatesX, List<Float> coordinatesY, List<Float> distancesSatellite, List<List<String>> messagesSatellites) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.distancesSatellite = distancesSatellite;
        this.messagesSatellites = messagesSatellites;
    }
}
