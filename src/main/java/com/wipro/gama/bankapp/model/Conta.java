package com.wipro.gama.bankapp.model;

abstract class Conta {
    String numConta;
    double saldo;
    String numCartao;


    public abstract void dadosConta();

    public abstract void saque(double value);

    public abstract void deposito(double value);


    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumCartao() {
        return numCartao;
    }
}
