/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.service.TemperatureService;
import com.conversions.demo.service.TemperatureServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author Karin
 */

@RunWith(SpringRunner.class)
@WebMvcTest(TemperatureController.class)
public class TemperatureControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private TemperatureService service;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void temperatureControllerTest() throws Exception {
        standaloneSetup(new TemperatureController(new TemperatureServiceImpl())).build()
			.perform(get("/temperature?value=19&from=celsius&to=fahrenheit").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"fahrenheit\":66.2,\"celsius\":19.0,\"kelvin\":292.15}"));
    
    }
    
    @Test
    public void temperatureControllerErrorTest() throws Exception {
        standaloneSetup(new TemperatureController(new TemperatureServiceImpl())).build()
			.perform(get("/temperature?value=19&from=celsius&to=fahrenhite").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());
    
    }

    
}
