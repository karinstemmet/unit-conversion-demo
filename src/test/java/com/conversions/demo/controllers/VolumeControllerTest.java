/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.service.VolumeService;
import com.conversions.demo.service.VolumeServiceImpl;
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
@WebMvcTest(VolumeController.class)
public class VolumeControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private VolumeService service;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void volumeControllerTest() throws Exception {
        standaloneSetup(new VolumeController(new VolumeServiceImpl())).build()
			.perform(get("/volume?value=1000&from=milliliter&to=fluidounce").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"milliliter\":1000.0,\"liter\":1.0,\"fluidOunce\":33.814,\"gallon\":0.219969}"));
    
    }
    
    @Test
    public void volumeControllerErrorTest() throws Exception {
        standaloneSetup(new VolumeController(new VolumeServiceImpl())).build()
			.perform(get("/volume?value=1000&from=mil&to=fluidounce").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());
    }
    
}
