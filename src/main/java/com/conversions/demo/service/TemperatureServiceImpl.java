/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Temperature;
import com.conversions.demo.entities.TemperatureUnitsEnum;
import org.springframework.stereotype.Service;


/**
 *
 * @author Karin
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {
    
        
     /**
     * Convert temperature entity. This switch statement determines which method to call based on what value
 the user would like to convert. Temperature object returned.
     *
     * @param value  
     * @param from
     * @param to
     * @return Temperature object
     */
    
    @Override
    public Temperature convertTemperature(Double value, TemperatureUnitsEnum from, TemperatureUnitsEnum to) {
        
        switch (from) {
            case FAHRENHEIT: return(convertFahrenheit(value));
            case CELSIUS: return(convertCelsius(value));
            case KELVIN: return(convertKelvin(value));
            default: return new Temperature();
        }
    }
    
    /**
     * This method converts the value from fahrenheit
     *
     *
     * @param amount
     * @return Temperature
     */
    private Temperature convertFahrenheit(Double amount) {
        Temperature convertedTemp = new Temperature();
        convertedTemp.setFahrenheit(amount);
        convertedTemp.setCelsius((amount-32)/1.8000);
        convertedTemp.setKelvin((amount-32)/1.8000+273.15);
        return convertedTemp;
    }
    
    /**
     * This method converts the value from celcius
     *
     *
     * @param amount
     * @return Temperature
     */
    private Temperature convertCelsius(Double amount) {
        Temperature convertedTemp = new Temperature();
        convertedTemp.setFahrenheit(amount*1.8000+32);
        convertedTemp.setCelsius(amount);
        convertedTemp.setKelvin(amount+273.15);
        return convertedTemp;
    }
    
    /**
     * This method converts the value from kelvin
     *
     *
     * @param amount
     * @return Temperature
     */
    private Temperature convertKelvin(Double amount) {
        Temperature convertedTemp = new Temperature();
        convertedTemp.setFahrenheit((amount-273.15)*1.8000+32);
        convertedTemp.setCelsius(amount-273.15);
        convertedTemp.setKelvin(amount);
        return convertedTemp;
    }
    
        
    
    
}
