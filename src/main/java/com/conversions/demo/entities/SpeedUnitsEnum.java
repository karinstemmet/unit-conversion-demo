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
public enum SpeedUnitsEnum {
    
    KPH("kph"),
    MPH("mph");

    private final String desc;

    SpeedUnitsEnum(String desc) {
        this.desc = desc;
    }

    public String description() {
        return desc;
    }

    public static SpeedUnitsEnum getSpeedUnitsEnumByName(String name) {
        for(SpeedUnitsEnum speedUnitsEnum : SpeedUnitsEnum.values()) {
            if (speedUnitsEnum.description().equals(name)) {
                return speedUnitsEnum;
            }
        }
        return null;
    }
    
}
