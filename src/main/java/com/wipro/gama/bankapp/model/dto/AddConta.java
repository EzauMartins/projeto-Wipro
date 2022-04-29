package com.wipro.gama.bankapp.model.dto;

public class AddConta {

    String numConta;
    double saldo;
    String numCartao;
    Double limiteAdicional;
    Double tax;


    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public Double getLimiteAdicional() {
        return limiteAdicional;
    }

    public void setLimiteAdicional(Double limiteAdicional) {
        this.limiteAdicional = limiteAdicional;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}

