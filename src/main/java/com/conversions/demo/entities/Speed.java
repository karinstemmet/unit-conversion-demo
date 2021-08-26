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
public class Speed {
    
    private Double kph;
    private Double mph;

    public Double getKph() {
        return kph;
    }

    public void setKph(Double kph) {
        this.kph = kph;
    }

    public Double getMph() {
        return mph;
    }

    public void setMph(Double mph) {
        this.mph = mph;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.kph);
        hash = 53 * hash + Objects.hashCode(this.mph);
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
        final Speed other = (Speed) obj;
        if (!Objects.equals(this.kph, other.kph)) {
            return false;
        }
        if (!Objects.equals(this.mph, other.mph)) {
            return false;
        }
        return true;
    }
    
    
    
}
