package com.pedrovega.operationquasarmlb.configuration;


import com.pedrovega.operationquasarmlb.exception.ErrorMessages;
import com.pedrovega.operationquasarmlb.exception.IndeterminateException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Component
@Configuration
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@EnableConfigurationProperties
@ConfigurationProperties(
        prefix = "satellite")
public class SatellitePositionsProperties {

    private Map<String, float[]> position;

    public float getPositionX(String satelliteName) {
        return validatePosition(satelliteName,0);
    }
    public float getPositionY(String satelliteName) {
        return validatePosition(satelliteName,1);
    }

    public float validatePosition(String satelliteName, int index) {
        if (getPosition().get(satelliteName)==null){
            throw new IndeterminateException(ErrorMessages.INVALID_SATELLITE.getMessage());
        }
        return getPosition().get(satelliteName)[index];
    }
}