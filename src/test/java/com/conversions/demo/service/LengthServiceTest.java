/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Length;
import com.conversions.demo.entities.LengthUnitsEnum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
public class LengthServiceTest {
    
    @Autowired
    private LengthService lengthServiceTest;
    
    @Test
    public void testConvertLength() {
        Double value = 100.00;
        LengthUnitsEnum from = LengthUnitsEnum.getLengthUnitsEnumByName("centimeter");
        LengthUnitsEnum to = LengthUnitsEnum.getLengthUnitsEnumByName("inch");
        LengthServiceImpl instance = new LengthServiceImpl();
        Length expResult = new Length();
        expResult.setCentimeter(100.0);
        expResult.setMeter(1.0);
        expResult.setKilometer(0.001);
        expResult.setInch(39.37);
        expResult.setFeet(3.2800000000000002);
        expResult.setMile(6.2137119E-4);
        Length result = instance.convertLength(value, from, to);
        assertEquals(true, expResult.equals(result));
    }
    
}
