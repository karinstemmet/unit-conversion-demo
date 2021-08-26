/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Temperature;
import com.conversions.demo.entities.TemperatureUnitsEnum;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Karin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureServiceTest {
    
    @Autowired
    private TemperatureService temperatureServiceTest;
    
    @Test
    public void testConvertSpeed() {
        Double value = 19.00;
        TemperatureUnitsEnum from = TemperatureUnitsEnum.getTemperatureUnitsEnumByName("celsius");
        TemperatureUnitsEnum to = TemperatureUnitsEnum.getTemperatureUnitsEnumByName("fahrenheit");
        TemperatureServiceImpl instance = new TemperatureServiceImpl();
        Temperature expResult = new Temperature();
        expResult.setCelsius(19.00);
        expResult.setFahrenheit(66.2);
        expResult.setKelvin(292.15);
        Temperature result = instance.convertTemperature(value, from, to);
        assertEquals(true, expResult.equals(result));
    }
    
}
