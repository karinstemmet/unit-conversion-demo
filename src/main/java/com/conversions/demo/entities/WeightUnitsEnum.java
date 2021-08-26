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
public enum WeightUnitsEnum {
    
    GRAM("gram"),
    KILOGRAM("kilogram"),
    OUNCE("ounce"),
    POUND("pound");

    private final String desc;

    WeightUnitsEnum(String desc) {
        this.desc = desc;
    }

    public String description() {
        return desc;
    }

    public static WeightUnitsEnum getWeightUnitsEnumByName(String name) {
        for(WeightUnitsEnum weightUnitsEnum : WeightUnitsEnum.values()) {
            if (weightUnitsEnum.description().equals(name)) {
                return weightUnitsEnum;
            }
        }
        return null;
    }
    
}
