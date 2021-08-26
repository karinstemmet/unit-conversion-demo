/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.controllers;

import com.conversions.demo.entities.Volume;
import com.conversions.demo.entities.VolumeUnitsEnum;
import com.conversions.demo.service.VolumeService;
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
public class VolumeController {
    
    private VolumeService service;
        
        public VolumeController(VolumeService volumeService) {
            this.service = volumeService;
        }

        /**
        * @RequestParam value = number to be converted
        * @RequestParam from = unit to be converted from
        * @RequestParam to = unit to be converted to
        */
        
        @CrossOrigin
        @GetMapping("/volume")
	public ResponseEntity<Object> convertVolume(@RequestParam(value = "value") Double value, 
                                    @RequestParam(value = "from") String from,
                                    @RequestParam(value = "to") String to) {
            
            VolumeUnitsEnum fromEnum = VolumeUnitsEnum.getVolumeUnitsEnumByName(from);
            if (fromEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            VolumeUnitsEnum toEnum = VolumeUnitsEnum.getVolumeUnitsEnumByName(to);
            if (toEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            Volume convertedVolume = service.convertVolume(value, fromEnum, toEnum);
            return new ResponseEntity<>(convertedVolume, HttpStatus.OK);
	
	}
    
}
