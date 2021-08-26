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


public enum TemperatureUnitsEnum {
    FAHRENHEIT("fahrenheit"),
    CELSIUS("celsius"),
    KELVIN("kelvin");

    private final String desc;

    TemperatureUnitsEnum(String desc) {
        this.desc = desc;
    }

    public String description() {
        return desc;
    }

    public static TemperatureUnitsEnum getTemperatureUnitsEnumByName(String name) {
        for(TemperatureUnitsEnum temperatureUnitsEnum : TemperatureUnitsEnum.values()) {
            if (temperatureUnitsEnum.description().equals(name)) {
                return temperatureUnitsEnum;
            }
        }
        return null;
    }


}

