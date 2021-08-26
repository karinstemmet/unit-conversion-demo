/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.entities;

/**
 *
 * @author Karin
 */
public enum LengthUnitsEnum {
    CENTIMETER("centimeter"),
    METER("meter"),
    KILOMETER("kilometer"),
    INCH("inch"),
    FEET("feet"),
    MILE("mile");

    private final String desc;

    LengthUnitsEnum(String desc) {
        this.desc = desc;
    }

    public String description() {
        return desc;
    }

    public static LengthUnitsEnum getLengthUnitsEnumByName(String name) {
        for(LengthUnitsEnum lengthUnitsEnum : LengthUnitsEnum.values()) {
            if (lengthUnitsEnum.description().equals(name)) {
                return lengthUnitsEnum;
            }
        }
        return null;
    }
    
}
