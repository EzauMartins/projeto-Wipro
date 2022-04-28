package com.wipro.gama.bankapp.model;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
abstract class Conta {

	@NotNull
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