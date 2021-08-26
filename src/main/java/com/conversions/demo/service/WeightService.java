/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Weight;
import com.conversions.demo.entities.WeightUnitsEnum;

/**
 *
 * @author Karin
 */
public interface WeightService {
    
    public Weight convertWeight(Double value, WeightUnitsEnum from, WeightUnitsEnum to);
    
}
