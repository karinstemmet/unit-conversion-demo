/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.service.WeightService;
import com.conversions.demo.service.WeightServiceImpl;
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
@WebMvcTest(WeightController.class)
public class WeightControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private WeightService service;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void weightControllerTest() throws Exception {
        standaloneSetup(new WeightController(new WeightServiceImpl())).build()
			.perform(get("/weight?value=1000&from=gram&to=ounce").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"gram\":1000.0,\"kilogram\":1.0,\"ounce\":35.27396195,\"pound\":2.20462262}"));
    
    }
    
    @Test
    public void weightControllerErrorTest() throws Exception {
        standaloneSetup(new WeightController(new WeightServiceImpl())).build()
			.perform(get("/weight?value=1000&from=gramm&to=ounce").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());
    }
    
}
