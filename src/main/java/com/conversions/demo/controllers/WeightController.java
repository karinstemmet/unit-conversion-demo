/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.entities.Weight;
import com.conversions.demo.entities.WeightUnitsEnum;
import com.conversions.demo.service.WeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karin
 */
@RestController
public class WeightController {
    
    private WeightService service;
        
        public WeightController(WeightService weightService) {
            this.service = weightService;
        }

        /**
        * @RequestParam value = number to be converted
        * @RequestParam from = unit to be converted from
        * @RequestParam to = unit to be converted to
        */
        
        @CrossOrigin
        @GetMapping("/weight")
	public ResponseEntity<Object> convertWeight(@RequestParam(value = "value") Double value, 
                                    @RequestParam(value = "from") String from,
                                    @RequestParam(value = "to") String to) {
            
            WeightUnitsEnum fromEnum = WeightUnitsEnum.getWeightUnitsEnumByName(from);
            if (fromEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            WeightUnitsEnum toEnum = WeightUnitsEnum.getWeightUnitsEnumByName(to);
            if (toEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            Weight convertedWeight = service.convertWeight(value, fromEnum, toEnum);
            return new ResponseEntity<>(convertedWeight, HttpStatus.OK);
	}
    
    
}
