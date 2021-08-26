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
 * The type Temperature.
 */
public class Temperature {

    
    private Double fahrenheit;
    private Double celsius;
    private Double kelvin;
    
    /**
     * Instantiates a new Temperature.
     */
    public Temperature(){}
    
    public Double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(Double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Double getCelsius() {
        return celsius;
    }

    public void setCelsius(Double celsius) {
        this.celsius = celsius;
    }

    public Double getKelvin() {
        return kelvin;
    }

    public void setKelvin(Double kelvin) {
        this.kelvin = kelvin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.fahrenheit);
        hash = 29 * hash + Objects.hashCode(this.celsius);
        hash = 29 * hash + Objects.hashCode(this.kelvin);
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
        final Temperature other = (Temperature) obj;
        if (!Objects.equals(this.fahrenheit, other.fahrenheit)) {
            return false;
        }
        if (!Objects.equals(this.celsius, other.celsius)) {
            return false;
        }
        if (!Objects.equals(this.kelvin, other.kelvin)) {
            return false;
        }
        return true;
    }
    
    
}
