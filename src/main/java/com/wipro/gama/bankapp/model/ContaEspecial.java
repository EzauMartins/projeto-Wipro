package com.wipro.gama.bankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tblContaEspecial")
public class ContaEspecial extends Conta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	double limiteAdicional;
	double tax = 5.0;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "CE")
	@JsonIgnore
	private Cliente cliente;

	public ContaEspecial() {
	}

	public ContaEspecial(String numConta, double saldo, double limiteAdicional, String numCartao) {
		this.numConta = numConta;
		this.saldo = saldo;
		this.limiteAdicional = limiteAdicional;
		this.numCartao = numCartao;
	}

	@Override
	public void saque(double value) {
		if (value > (saldo + limiteAdicional)) {
			System.out.println("Saldo insuficiente");
		}
		else {
			double tax = 7.0;
			saldo = saldo -(value + tax);
		}
	}

	public void transferir(double value) {
		if (value > (saldo + limiteAdicional)) {
			System.out.println("Saldo insuficiente");
		}
		else {
			saldo = saldo - value;
		}
	}


	@Override
	public void deposito(double value) {
		saldo = saldo + value;
	}

	
	@Override
	public String toString() {
		return " numConta: " +
				numConta + "\n saldo: " +
				saldo + "\n numCartao: " 
				+ numCartao ;
	}
	@Override
	public void dadosConta() {
		System.out.println("=======Dados da conta======="+"\n"+
				"Numero Conta: "+this.numCartao+"\n"+
				"Saldo atual: "+this.saldo);
	}


	public int getId() {
		return Id;
	}

	public double getLimiteAdicional() {
		return limiteAdicional;
	}

	public void setLimiteAdicional(double limiteAdicional) {
		this.limiteAdicional = limiteAdicional;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}