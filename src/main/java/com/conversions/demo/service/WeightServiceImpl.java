/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Weight;
import com.conversions.demo.entities.WeightUnitsEnum;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karin
 */
@Service
public class WeightServiceImpl implements WeightService{
    
    /**
     * Convert Weight object. This switch statement determines which method to call based on what value
 the user would like to convert. Weight object returned.
     *
     * @param value  
     * @param from
     * @param to
     * @return length object
     */
    
    @Override
    public Weight convertWeight(Double value, WeightUnitsEnum from, WeightUnitsEnum to) {
        
        switch (from) {
            case GRAM: return(convertGram(value));
            case KILOGRAM: return(convertKilogram(value));
            case OUNCE: return(convertOunce(value));
            case POUND: return(convertPound(value));
            default: return new Weight();
        }
    }
    
    /**
     * This method converts the value from gram to other units of weight.
     *
     * @param amount 
     * @return Weight Object
     */
    private Weight convertGram(Double amount) {
        Weight convertedWeight = new Weight();
        convertedWeight.setGram(amount);
        convertedWeight.setKilogram(amount*0.001);
        convertedWeight.setOunce(amount*0.03527396195);
        convertedWeight.setPound(amount*0.00220462262);

        return convertedWeight;
    }
    
    /**
     * This method converts the value from kilogram to other units of weight.
     *
     * @param amount 
     * @return Weight Object
     */
    private Weight convertKilogram(Double amount) {
        Weight convertedWeight = new Weight();
        convertedWeight.setKilogram(amount);
        convertedWeight.setGram(amount*1000);
        convertedWeight.setOunce(amount*35.2739619);
        convertedWeight.setPound(amount*2.20462262);

        return convertedWeight;
    }
    
    /**
     * This method converts the value from ounce to other units of weight.
     *
     * @param amount 
     * @return Weight Object
     */
    private Weight convertOunce(Double amount) {
        Weight convertedWeight = new Weight();
        convertedWeight.setOunce(amount);
        convertedWeight.setGram(amount*28.3495);
        convertedWeight.setKilogram(amount*0.0283495);
        convertedWeight.setPound(amount*0.0625);

        return convertedWeight;
    }
    
    /**
     * This method converts the value from pound to other units of weight.
     *
     * @param amount 
     * @return Weight Object
     */
    private Weight convertPound(Double amount) {
        Weight convertedWeight = new Weight();
        convertedWeight.setPound(amount);
        convertedWeight.setGram(amount*453.592);
        convertedWeight.setKilogram(amount*0.453592);
        convertedWeight.setOunce(amount*16);

        return convertedWeight;
    }
    
}
