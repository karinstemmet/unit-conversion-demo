/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.entities.Speed;
import com.conversions.demo.entities.SpeedUnitsEnum;
import com.conversions.demo.service.SpeedService;
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
public class SpeedController {
    
    private SpeedService service;
        
        public SpeedController(SpeedService speedService) {
            this.service = speedService;
        }

        /**
        * @RequestParam value = number to be converted
        * @RequestParam from = unit to be converted from
        * @RequestParam to = unit to be converted to
        */
        
        @CrossOrigin
        @GetMapping("/speed")
	public ResponseEntity<Object> convertSpeed(@RequestParam(value = "value") Double value, 
                                    @RequestParam(value = "from") String from,
                                    @RequestParam(value = "to") String to) {
            
            SpeedUnitsEnum fromEnum = SpeedUnitsEnum.getSpeedUnitsEnumByName(from);
            if (fromEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            SpeedUnitsEnum toEnum = SpeedUnitsEnum.getSpeedUnitsEnumByName(to);
            if (toEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            Speed convertedSpeed = service.convertSpeed(value, fromEnum, toEnum);
            return new ResponseEntity<>(convertedSpeed, HttpStatus.OK);
	}
    
}
