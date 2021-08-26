/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Length;
import com.conversions.demo.entities.LengthUnitsEnum;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karin
 */
@Service
public class LengthServiceImpl implements LengthService {
    /**
     * Convert length object. This switch statement determines which method to call based on what value
 the user would like to convert. Length object returned.
     *
     * @param value  
     * @param from
     * @param to
     * @return length object
     */
    
    @Override
    public Length convertLength(Double value, LengthUnitsEnum from, LengthUnitsEnum to) {
        
        switch (from) {
            case CENTIMETER: return(convertCentimeter(value));
            case METER: return(convertMeter(value));
            case KILOMETER: return(convertKilometer(value));
            case INCH: return(convertInch(value));
            case FEET: return(convertFeet(value));
            case MILE: return(convertMile(value));
            default: return new Length();
        }
    }
    
    /**
     * This method converts the value from centimeter
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertCentimeter(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setCentimeter(amount);
        convertedLength.setMeter(amount*0.01);
        convertedLength.setKilometer(amount*1.0e-5);
        convertedLength.setInch(amount*0.3937);
        convertedLength.setFeet(amount*0.0328);
        convertedLength.setMile(amount*6.2137119e-6);

        return convertedLength;
    }
    
    /**
     * This method converts the value from meter
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertMeter(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setMeter(amount);
        convertedLength.setCentimeter(amount*100);
        convertedLength.setKilometer(amount*0.001);
        convertedLength.setInch(amount*39.37);
        convertedLength.setFeet(amount*3.281);
        convertedLength.setMile(amount*0.000621371);

        return convertedLength;
    }
    
    /**
     * This method converts the value from kilometer
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertKilometer(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setKilometer(amount);
        convertedLength.setCentimeter(amount*100000);
        convertedLength.setMeter(amount*1000);
        convertedLength.setInch(amount*39370.079);
        convertedLength.setFeet(amount*3280.84);
        convertedLength.setMile(amount*0.621371);
        return convertedLength;
    }
    
    /**
     * This method converts the value from inch
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertInch(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setInch(amount);
        convertedLength.setCentimeter(amount*2.54);
        convertedLength.setMeter(amount*0.0254);
        convertedLength.setKilometer(amount*2.54e-5);
        convertedLength.setFeet(amount*0.0833333);
        convertedLength.setMile(amount*1.5782828e-5);
        return convertedLength;
    }
    
    /**
     * This method converts the value from feet into other units of length.
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertFeet(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setFeet(amount);
        convertedLength.setCentimeter(amount*30.48);
        convertedLength.setMeter(amount*0.3048);
        convertedLength.setKilometer(amount*0.0003048);
        convertedLength.setInch(amount*12);
        convertedLength.setMile(amount*0.00018939394);
        return convertedLength;
    }
    
    /**
     * This method converts the value from mile into other units of length.
     *
     * @param amount 
     * @return Length Object
     */
    private Length convertMile(Double amount) {
        Length convertedLength = new Length();
        convertedLength.setMile(amount);
        convertedLength.setCentimeter(amount*160934.4);
        convertedLength.setMeter(amount*1609.344);
        convertedLength.setKilometer(amount*1.609);
        convertedLength.setInch(amount*63360);
        convertedLength.setFeet(amount*5280);

        return convertedLength;
    }
    
}
