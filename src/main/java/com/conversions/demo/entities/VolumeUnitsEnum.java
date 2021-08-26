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
public enum VolumeUnitsEnum {
    
    MILLILITER("milliliter"),
    LITER("liter"),
    FLUIDOUNCE("fluidounce"),
    GALLON("gallon");

    private final String desc;

    VolumeUnitsEnum(String desc) {
        this.desc = desc;
    }

    public String description() {
        return desc;
    }

    public static VolumeUnitsEnum getVolumeUnitsEnumByName(String name) {
        for(VolumeUnitsEnum volumeUnitsEnum : VolumeUnitsEnum.values()) {
            if (volumeUnitsEnum.description().equals(name)) {
                return volumeUnitsEnum;
            }
        }
        return null;
    }

    
}
