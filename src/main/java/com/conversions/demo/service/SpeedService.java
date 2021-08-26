/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Speed;
import com.conversions.demo.entities.SpeedUnitsEnum;

/**
 *
 * @author Karin
 */
public interface SpeedService {
    
    public Speed convertSpeed(Double value, SpeedUnitsEnum from, SpeedUnitsEnum to);
    
}
