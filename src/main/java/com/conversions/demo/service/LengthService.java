/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Length;
import com.conversions.demo.entities.LengthUnitsEnum;

/**
 *
 * @author Karin
 */
public interface LengthService {
    
    public Length convertLength(Double value, LengthUnitsEnum from, LengthUnitsEnum to);
    
}
