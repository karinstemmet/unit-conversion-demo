package com.conversions.demo.controllers;

import com.conversions.demo.entities.Temperature;
import com.conversions.demo.entities.TemperatureUnitsEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.conversions.demo.service.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class TemperatureController {

        private TemperatureService service;
        
        public TemperatureController(TemperatureService temperatureService) {
            this.service = temperatureService;
        }

        /**
        * @RequestParam value = number to be converted
        * @RequestParam from = unit to be converted from
        * @RequestParam to = unit to be converted to
        */
        @CrossOrigin
        @GetMapping("/temperature")
	public ResponseEntity<Temperature> convertTemperature(@RequestParam(value = "value") Double value, 
                                    @RequestParam(value = "from") String from,
                                    @RequestParam(value = "to") String to) {
            
            TemperatureUnitsEnum fromEnum = TemperatureUnitsEnum.getTemperatureUnitsEnumByName(from);
            if (fromEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            TemperatureUnitsEnum toEnum = TemperatureUnitsEnum.getTemperatureUnitsEnumByName(to);
            if (toEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            Temperature convertedTemperature = service.convertTemperature(value, fromEnum, toEnum);
            return new ResponseEntity<>(convertedTemperature, HttpStatus.OK);
	}
        
        
}