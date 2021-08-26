/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.service.SpeedService;
import com.conversions.demo.service.SpeedServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author Karin
 */

@RunWith(SpringRunner.class)
@WebMvcTest(SpeedController.class)
public class SpeedControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private SpeedService service;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void speedControllerTest() throws Exception {
        standaloneSetup(new SpeedController(new SpeedServiceImpl())).build()
			.perform(get("/speed?value=100&from=kph&to=mph").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"kph\":100.0,\"mph\":62.137100000000004}"));
    
    }
    
    @Test
    public void speedControllerErrorTest() throws Exception {
        standaloneSetup(new SpeedController(new SpeedServiceImpl())).build()
			.perform(get("/speed?value=100&from=km&to=mph").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());
    
    }
    
}
