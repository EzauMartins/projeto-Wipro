package com.wipro.gama.bankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Historico {

    @Id
    Integer id;

    double valor;

    @JsonIgnore
    Date data = new Date(System.currentTimeMillis());

    String Destino;



    public Historico(){

    }

    public Historico(Integer id, double valor, Date data, String destino) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        Destino = destino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }
}