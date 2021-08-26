/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.service;

import com.conversions.demo.entities.Volume;
import com.conversions.demo.entities.VolumeUnitsEnum;
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
public class VolumeServiceTest {
    
    @Autowired
    private VolumeService VolumeServiceTest;
    
    @Test
    public void testConvertVolume() {
        Double value = 1000.00;
        VolumeUnitsEnum from = VolumeUnitsEnum.getVolumeUnitsEnumByName("milliliter");
        VolumeUnitsEnum to = VolumeUnitsEnum.getVolumeUnitsEnumByName("fluidounce");
        VolumeServiceImpl instance = new VolumeServiceImpl();
        Volume expResult = new Volume();
        expResult.setMilliliter(1000.00);
        expResult.setLiter(1.0);
        expResult.setFluidOunce(33.814);
        expResult.setGallon(0.219969);
        Volume result = instance.convertVolume(value, from, to);
        assertEquals(true, expResult.equals(result));
    }
    
}
