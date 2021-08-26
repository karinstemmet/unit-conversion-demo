package com.conversions.demo.controllers;

import com.conversions.demo.entities.Length;
import com.conversions.demo.entities.LengthUnitsEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.conversions.demo.service.LengthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class LengthController {

        private LengthService service;
        
        public LengthController(LengthService lengthService) {
            this.service = lengthService;
        }

        /**
        * @RequestParam value = number to be converted
        * @RequestParam from = unit to be converted from
        * @RequestParam to = unit to be converted to
        */
        
        @CrossOrigin
        @GetMapping("/length")
	public ResponseEntity<Object> convertLength(@RequestParam(value = "value") Double value, 
                                    @RequestParam(value = "from") String from,
                                    @RequestParam(value = "to") String to) {
            
            LengthUnitsEnum fromEnum = LengthUnitsEnum.getLengthUnitsEnumByName(from);
            if (fromEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            LengthUnitsEnum toEnum = LengthUnitsEnum.getLengthUnitsEnumByName(to);
            if (toEnum == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            Length convertedLength = service.convertLength(value, fromEnum, toEnum);
            return new ResponseEntity<>(convertedLength, HttpStatus.OK);
	}
        
        
}