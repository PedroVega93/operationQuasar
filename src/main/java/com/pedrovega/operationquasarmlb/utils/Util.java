package com.pedrovega.operationquasarmlb.utils;

import com.pedrovega.operationquasarmlb.configuration.SatellitePositionsProperties;
import com.pedrovega.operationquasarmlb.db.entity.Satellites;
import com.pedrovega.operationquasarmlb.db.repository.SatellitesRepository;
import com.pedrovega.operationquasarmlb.domain.Position;
import com.pedrovega.operationquasarmlb.domain.Satellite;
import com.pedrovega.operationquasarmlb.domain.SatellitesInformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Util {

    public static SatellitesInformation getListOfSatellites(List<Satellite> satellites,List<Satellites> existingSatellites,int arraySize, SatellitePositionsProperties satellitePositions){

        List<Float> coordinatesX = new ArrayList<>();
        List<Float> coordinatesY = new ArrayList<>();
        List<Float> distancesSatellite = new ArrayList<>();
        List<List<String>> messagesSatellites = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            coordinatesX.add(i,satellitePositions.getPositionX(satellites != null ? satellites.get(i).getName() : existingSatellites.get(i).getName()));
            coordinatesY.add(i, satellitePositions.getPositionY(satellites != null ? satellites.get(i).getName() : existingSatellites.get(i).getName()));
            distancesSatellite.add(i, satellites != null ? satellites.get(i).getDistance() : existingSatellites.get(i).getDistance());
            messagesSatellites.add(i, satellites != null ? satellites.get(i).getMessage() : new ArrayList<>(Arrays.asList(existingSatellites.get(i).getMessage().split(",",-1))));
        }
        return new SatellitesInformation(coordinatesX,coordinatesY,distancesSatellite,messagesSatellites);
    }

    public static Position getPosition(List<Float> coordinatesX, List<Float> coordinatesY, List<Float> distancesSatellite) {
        float va = (float) (Math.pow(distancesSatellite.get(1),2)-Math.pow(distancesSatellite.get(2),2)-(Math.pow(coordinatesX.get(1),2)-Math.pow(coordinatesX.get(2),2))-(Math.pow(coordinatesY.get(1),2)-Math.pow(coordinatesY.get(2),2)))/2;
        float vb = (float) (Math.pow(distancesSatellite.get(1),2)-Math.pow(distancesSatellite.get(0),2)-(Math.pow(coordinatesX.get(1),2)-Math.pow(coordinatesX.get(0),2))-(Math.pow(coordinatesY.get(1),2)-Math.pow(coordinatesY.get(0),2)))/2;

        float y = (vb*(coordinatesX.get(2)-coordinatesX.get(1))-va*(coordinatesX.get(0)-coordinatesX.get(1)))/((coordinatesY.get(0)-coordinatesY.get(1))*(coordinatesX.get(2)-coordinatesX.get(1))-(coordinatesY.get(2)-coordinatesY.get(1))*(coordinatesX.get(0)-coordinatesX.get(1)));
        float x = (va - y*(coordinatesY.get(2)-coordinatesY.get(1)))/(coordinatesX.get(2)-coordinatesX.get(1));

        return new Position(x,y);
    }
    public static String getMessage(List<List<String>> messagesSatellites){
        int index = 0;
        int menor = messagesSatellites.get(index).size();
        for (int x=0;x<messagesSatellites.size();x++){
            if (messagesSatellites.get(x).size()<menor){
                menor=messagesSatellites.get(x).size();
                index=x;
            }
        }
        List<String> mf = messagesSatellites.get(index);

        for(int j=0;j< messagesSatellites.size();j++){
            if (messagesSatellites.get(j).size()==mf.size()){
                validateMessage(j,messagesSatellites,mf);
            } else if (messagesSatellites.get(j).size()>mf.size()){
                while (mf.contains("")&&messagesSatellites.get(j).size()>=mf.size()) {
                    messagesSatellites.get(j).remove(0);
                    if (messagesSatellites.get(j).size()==mf.size())
                        validateMessage(j,messagesSatellites,mf);
                }
            }
        }
        return String.join(" ",mf);
    }

    public static void validateMessage(int j,List<List<String>> messagesSatellites,List<String> mf){
        for (int i=0;i<messagesSatellites.get(j).size();i++){
            if ("".equals(mf.get(i)))
                mf.set(i,messagesSatellites.get(j).get(i));
        }
    }

    public static void saveOrUpdateSatellite(String satelliteName, Satellites satellites, SatellitesRepository satellitesRepository){
        Satellites existingSatellite = satellitesRepository.findByName(satelliteName);
        if (existingSatellite!=null){
            existingSatellite.setDistance(satellites.getDistance());
            existingSatellite.setMessage(satellites.getMessage());
            satellitesRepository.save(existingSatellite);
        }else{
            satellitesRepository.save(satellites);
        }
    }
}
