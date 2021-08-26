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
* Instantiates a new Weight object.
*/
public class Weight {
    
    private Double gram;
    private Double kilogram;
    private Double ounce;
    private Double pound;

    public Double getGram() {
        return gram;
    }

    public void setGram(Double gram) {
        this.gram = gram;
    }

    public Double getKilogram() {
        return kilogram;
    }

    public void setKilogram(Double kilogram) {
        this.kilogram = kilogram;
    }

    public Double getOunce() {
        return ounce;
    }

    public void setOunce(Double ounce) {
        this.ounce = ounce;
    }

    public Double getPound() {
        return pound;
    }

    public void setPound(Double pound) {
        this.pound = pound;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.gram);
        hash = 19 * hash + Objects.hashCode(this.kilogram);
        hash = 19 * hash + Objects.hashCode(this.ounce);
        hash = 19 * hash + Objects.hashCode(this.pound);
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
        final Weight other = (Weight) obj;
        if (!Objects.equals(this.gram, other.gram)) {
            return false;
        }
        if (!Objects.equals(this.kilogram, other.kilogram)) {
            return false;
        }
        if (!Objects.equals(this.ounce, other.ounce)) {
            return false;
        }
        if (!Objects.equals(this.pound, other.pound)) {
            return false;
        }
        return true;
    }
    
    
    
}
