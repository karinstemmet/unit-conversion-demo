/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.service.LengthService;
import com.conversions.demo.service.LengthServiceImpl;
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
@WebMvcTest(LengthController.class)
public class LengthControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private LengthService service;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void lengthControllerTest() throws Exception {
        standaloneSetup(new LengthController(new LengthServiceImpl())).build()
			.perform(get("/length?value=1000&from=centimeter&to=inch").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"centimeter\":1000.0,\"meter\":10.0,\"kilometer\":0.01,\"inch\":393.7,\"feet\":32.800000000000004,\"mile\":0.0062137119}"));
    
    }
    
    @Test
    public void lengthControllerErrorTest() throws Exception {
        standaloneSetup(new LengthController(new LengthServiceImpl())).build()
			.perform(get("/length?value=1000&from=centimeter&to=inches").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());   
    }
    
}
