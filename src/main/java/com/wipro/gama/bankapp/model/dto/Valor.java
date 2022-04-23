package com.wipro.gama.bankapp.model.dto;

import java.io.Serializable;

public class Valor implements Serializable {
    private double value;

    public Valor() {
    }

    public Valor(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
