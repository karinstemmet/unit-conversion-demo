/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Temperature;
import com.conversions.demo.entities.TemperatureUnitsEnum;

/**
 *
 * @author Karin
 */
public interface TemperatureService {
  
  public Temperature convertTemperature(Double value, TemperatureUnitsEnum from, TemperatureUnitsEnum to);

    
}
