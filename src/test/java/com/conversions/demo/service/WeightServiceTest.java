/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Weight;
import com.conversions.demo.entities.WeightUnitsEnum;
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
public class WeightServiceTest {
    
    @Autowired
    private WeightService WeightServiceTest;
    
    @Test
    public void testConvertWeight() {
        Double value = 1000.00;
        WeightUnitsEnum from = WeightUnitsEnum.getWeightUnitsEnumByName("gram");
        WeightUnitsEnum to = WeightUnitsEnum.getWeightUnitsEnumByName("ounce");
        WeightServiceImpl instance = new WeightServiceImpl();
        Weight expResult = new Weight();
        expResult.setGram(1000.00);
        expResult.setKilogram(1.0);
        expResult.setOunce(35.27396195);
        expResult.setPound(2.20462262);
        Weight result = instance.convertWeight(value, from, to);
        assertEquals(true, expResult.equals(result));
    }
    
}
