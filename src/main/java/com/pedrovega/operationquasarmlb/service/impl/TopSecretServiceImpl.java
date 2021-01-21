package com.pedrovega.operationquasarmlb.service.impl;

import com.pedrovega.operationquasarmlb.domain.Satellite;
import com.pedrovega.operationquasarmlb.dto.TopSecretRequestDTO;
import com.pedrovega.operationquasarmlb.dto.TopSecretResponseDTO;
import com.pedrovega.operationquasarmlb.service.ITopSecretService;
import org.springframework.stereotype.Service;

@Service
public class TopSecretServiceImpl implements ITopSecretService {

    @Override
    public TopSecretResponseDTO topsecret(TopSecretRequestDTO topSecretRequestDTO) {

        final String KENOBI = "kenobi";
        final String SKYWALKER = "skywalker";
        final String SATO = "sato";

        float kennobyX = -5;
        float kennobyY = -2;
        float skywalkerX = 1;
        float skywalkerY = -2;
        float satoX = 5;
        float satoY = 1;




        int incrementor = 0;

        float coordinatesX[] = new float[3];
        float coordinatesY[] = new float[3];
        float distancesSatellite[] = new float[3];

        for (Satellite satellite : topSecretRequestDTO.getSatellites()) {
            if(KENOBI.equals(satellite.getName())){
                distancesSatellite[incrementor] =satellite.getDistance();
                coordinatesX[incrementor] =kennobyX;
                coordinatesY[incrementor] =kennobyY;
            }else if(SKYWALKER.equals(satellite.getName())){
                distancesSatellite[incrementor] =satellite.getDistance();
                coordinatesX[incrementor] =skywalkerX;
                coordinatesY[incrementor] =skywalkerY;
            }else if(SATO.equals(satellite.getName())){
                distancesSatellite[incrementor] =satellite.getDistance();
                coordinatesX[incrementor] =satoX;
                coordinatesY[incrementor] =satoY;
            }
            incrementor++;
        }

        System.out.print("distancesSatellite[0] = " +distancesSatellite[0] +"\n");
        System.out.print("coordinatesX[0] = " +coordinatesX[0] +"\n");
        System.out.print("coordinatesY[0] = " +coordinatesY[0] +"\n");

        System.out.print("distancesSatellite[1] = " +distancesSatellite[1] +"\n");
        System.out.print("coordinatesX[1] = " +coordinatesX[1] +"\n");
        System.out.print("coordinatesY[1] = " +coordinatesY[1] +"\n");

        System.out.print("distancesSatellite[2] = " +distancesSatellite[2] +"\n");
        System.out.print("coordinatesX[2] = " +coordinatesX[2] +"\n");
        System.out.print("coordinatesY[2] = " +coordinatesY[2] +"\n");


        float va = (float) (Math.pow(distancesSatellite[1],2)-Math.pow(distancesSatellite[2],2)-(Math.pow(coordinatesX[1],2)-Math.pow(coordinatesX[2],2))-(Math.pow(coordinatesY[1],2)-Math.pow(coordinatesY[2],2)))/2;
        float vb = (float) (Math.pow(distancesSatellite[1],2)-Math.pow(distancesSatellite[0],2)-(Math.pow(coordinatesX[1],2)-Math.pow(coordinatesX[0],2))-(Math.pow(coordinatesY[1],2)-Math.pow(coordinatesY[0],2)))/2;

        float y = (vb*(coordinatesX[2]-coordinatesX[1])-va*(coordinatesX[0]-coordinatesX[1]))/((coordinatesY[0]-coordinatesY[1])*(coordinatesX[2]-coordinatesX[1])-(coordinatesY[2]-coordinatesY[1])*(coordinatesX[0]-coordinatesX[1]));
        float x = (va - y*(coordinatesY[2]-coordinatesY[1]))/(coordinatesX[2]-coordinatesX[1]);

        System.out.print("x = " +x +"\n");
        System.out.print("y = " +y +"\n");


        float x1 =-5;
        float y1 =-2;
        float d1 = 10;

        float x2 =1;
        float y2 =-2;
        float d2 = 15;

        float x3 =5;
        float y3 =1;
        float d3 = 20;

        float a = (float) (Math.pow(d2,2)-Math.pow(d3,2)-(Math.pow(x2,2)-Math.pow(x3,2))-(Math.pow(y2,2)-Math.pow(y3,2)))/2;
        float b = (float) (Math.pow(d2,2)-Math.pow(d1,2)-(Math.pow(x2,2)-Math.pow(x1,2))-(Math.pow(y2,2)-Math.pow(y1,2)))/2;

        float y0 = (b*(x3-x2)-a*(x1-x2))/((y1-y2)*(x3-x2)-(y3-y2)*(x1-x2));
        float x0 = (a - y0*(y3-y2))/(x3-x2);

        System.out.print("x = " +x0+"\n");
        System.out.print("y = " +y0+"\n");

        return null;
    }
}
