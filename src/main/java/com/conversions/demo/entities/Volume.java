/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conversions.demo.entities;

import java.util.Objects;

/**
 *
 * @author Karin
 */

/**
* Instantiates a new Volume object.
*/
public class Volume {
    
    private Double milliliter;
    private Double liter;
    private Double fluidOunce;
    private Double gallon;

    public Double getMilliliter() {
        return milliliter;
    }

    public void setMilliliter(Double milliliter) {
        this.milliliter = milliliter;
    }

    public Double getLiter() {
        return liter;
    }

    public void setLiter(Double liter) {
        this.liter = liter;
    }

    public Double getFluidOunce() {
        return fluidOunce;
    }

    public void setFluidOunce(Double fluidOunce) {
        this.fluidOunce = fluidOunce;
    }

    public Double getGallon() {
        return gallon;
    }

    public void setGallon(Double gallon) {
        this.gallon = gallon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.milliliter);
        hash = 61 * hash + Objects.hashCode(this.liter);
        hash = 61 * hash + Objects.hashCode(this.fluidOunce);
        hash = 61 * hash + Objects.hashCode(this.gallon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Volume other = (Volume) obj;
        if (!Objects.equals(this.milliliter, other.milliliter)) {
            return false;
        }
        if (!Objects.equals(this.liter, other.liter)) {
            return false;
        }
        if (!Objects.equals(this.fluidOunce, other.fluidOunce)) {
            return false;
        }
        if (!Objects.equals(this.gallon, other.gallon)) {
            return false;
        }
        return true;
    }
    
    
}
