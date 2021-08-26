/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Volume;
import com.conversions.demo.entities.VolumeUnitsEnum;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karin
 */
@Service
public class VolumeServiceImpl implements VolumeService {
    
    /**
     * Convert Volume object. This switch statement determines which method to call based on what value
 the user would like to convert. volume object returned.
     *
     * @param value  
     * @param from
     * @param to
     * @return length object
     */
    
    @Override
    public Volume convertVolume(Double value, VolumeUnitsEnum from, VolumeUnitsEnum to) {
        
        switch (from) {
            case MILLILITER: return(convertMilliliter(value));
            case LITER: return(convertLiter(value));
            case FLUIDOUNCE: return(convertFluidOunce(value));
            case GALLON: return(convertGallon(value));
            default: return new Volume();
        }
    }
    
    /**
     * This method converts the value from milliliter other units of volume.
     *
     * @param amount 
     * @return Volume Object
     */
    private Volume convertMilliliter(Double amount) {
        Volume convertedVolume = new Volume();
        convertedVolume.setMilliliter(amount);
        convertedVolume.setLiter(amount*0.001);
        convertedVolume.setFluidOunce(amount*0.033814);
        convertedVolume.setGallon(amount*0.000219969);

        return convertedVolume;
    }
    
    /**
     * This method converts the value from liter other units of volume.
     *
     * @param amount 
     * @return Volume Object
     */
    private Volume convertLiter(Double amount) {
        Volume convertedVolume = new Volume();
        convertedVolume.setLiter(amount);
        convertedVolume.setMilliliter(amount*1000);
        convertedVolume.setFluidOunce(amount*33.814);
        convertedVolume.setGallon(amount*0.219969);
        
        return convertedVolume;
    }
    
    /**
     * This method converts the value from fluidOunce other units of volume.
     *
     * @param amount 
     * @return Volume Object
     */
    private Volume convertFluidOunce(Double amount) {
        Volume convertedVolume = new Volume();
        convertedVolume.setFluidOunce(amount);
        convertedVolume.setMilliliter(amount*29.5735);
        convertedVolume.setLiter(amount*0.0295735);
        convertedVolume.setGallon(amount*0.00650527);
        
        return convertedVolume;
    }
    
    /**
     * This method converts the value from gallon other units of volume.
     *
     * @param amount 
     * @return Volume Object
     */
    
    private Volume convertGallon(Double amount) {
        Volume convertedVolume = new Volume();
        convertedVolume.setGallon(amount);
        convertedVolume.setFluidOunce(amount*159.9998193936);
        convertedVolume.setMilliliter(amount*4546.084868);
        convertedVolume.setLiter(amount*4.546084868);
        
        return convertedVolume;
    }
    
}
