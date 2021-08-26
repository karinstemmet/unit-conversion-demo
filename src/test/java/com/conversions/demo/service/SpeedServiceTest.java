/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Speed;
import com.conversions.demo.entities.SpeedUnitsEnum;
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
public class SpeedServiceTest {
    
    @Autowired
    private SpeedService speedServiceTest;
    
    @Test
    public void testConvertSpeed() {
        Double value = 100.00;
        SpeedUnitsEnum from = SpeedUnitsEnum.getSpeedUnitsEnumByName("kph");
        SpeedUnitsEnum to = SpeedUnitsEnum.getSpeedUnitsEnumByName("mph");
        SpeedServiceImpl instance = new SpeedServiceImpl();
        Speed expResult = new Speed();
        expResult.setKph(100.00);
        expResult.setMph(62.137100000000004);
        Speed result = instance.convertSpeed(value, from, to);
        assertEquals(true, expResult.equals(result));
    }
    
}
