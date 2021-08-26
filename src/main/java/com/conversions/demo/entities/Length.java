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
* Instantiates a new Length object.
*/
public class Length {

    
    
    private Double centimeter;
    private Double meter;
    private Double kilometer;
    private Double inch;
    private Double feet;
    private Double mile;

    public Double getCentimeter() {
        return centimeter;
    }

    public void setCentimeter(Double centimeter) {
        this.centimeter = centimeter;
    }

    public Double getMeter() {
        return meter;
    }

    public void setMeter(Double meter) {
        this.meter = meter;
    }

    public Double getKilometer() {
        return kilometer;
    }

    public void setKilometer(Double kilometer) {
        this.kilometer = kilometer;
    }

    public Double getInch() {
        return inch;
    }

    public void setInch(Double inch) {
        this.inch = inch;
    }

    public Double getFeet() {
        return feet;
    }

    public void setFeet(Double feet) {
        this.feet = feet;
    }

    public Double getMile() {
        return mile;
    }

    public void setMile(Double mile) {
        this.mile = mile;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.centimeter);
        hash = 29 * hash + Objects.hashCode(this.meter);
        hash = 29 * hash + Objects.hashCode(this.kilometer);
        hash = 29 * hash + Objects.hashCode(this.inch);
        hash = 29 * hash + Objects.hashCode(this.feet);
        hash = 29 * hash + Objects.hashCode(this.mile);
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
        final Length other = (Length) obj;
        if (!Objects.equals(this.centimeter, other.centimeter)) {
            return false;
        }
        if (!Objects.equals(this.meter, other.meter)) {
            return false;
        }
        if (!Objects.equals(this.kilometer, other.kilometer)) {
            return false;
        }
        if (!Objects.equals(this.inch, other.inch)) {
            return false;
        }
        if (!Objects.equals(this.feet, other.feet)) {
            return false;
        }
        if (!Objects.equals(this.mile, other.mile)) {
            return false;
        }
        return true;
    }
}
