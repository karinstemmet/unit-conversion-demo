/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Speed;
import com.conversions.demo.entities.SpeedUnitsEnum;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karin
 */
@Service
public class SpeedServiceImpl implements SpeedService {
    
    /**
     * Convert speed entity. This switch statement determines which method to call based on what value
 the user would like to convert. Temperature object returned.
     *
     * @param value  
     * @param from
     * @param to
     * @return Temperature object
     */
    
    @Override
    public Speed convertSpeed(Double value, SpeedUnitsEnum from, SpeedUnitsEnum to) {
        
        switch (from) {
            case KPH: return(convertKph(value));
            case MPH: return(convertMph(value));
            default: return new Speed();
        }
    }
    
    /**
     * This method converts the value from kph to mph
     *
     *
     * @param amount
     * @return Speed
     */
    private Speed convertKph(Double amount) {
        Speed convertedSpeed = new Speed();
        convertedSpeed.setKph(amount);
        convertedSpeed.setMph(amount * 0.621371);
        return convertedSpeed;
    }
    
    /**
     * This method converts the value from mph to kph
     *
     *
     * @param amount
     * @return Speed
     */
    private Speed convertMph(Double amount) {
        Speed convertedSpeed = new Speed();
        convertedSpeed.setKph(amount * 1.60934);
        convertedSpeed.setMph(amount);
        return convertedSpeed;
    }
    
}
