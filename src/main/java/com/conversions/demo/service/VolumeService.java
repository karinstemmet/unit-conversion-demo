/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Volume;
import com.conversions.demo.entities.VolumeUnitsEnum;

/**
 *
 * @author Karin
 */
public interface VolumeService {
    
    public Volume convertVolume(Double value, VolumeUnitsEnum from, VolumeUnitsEnum to);
    
}
