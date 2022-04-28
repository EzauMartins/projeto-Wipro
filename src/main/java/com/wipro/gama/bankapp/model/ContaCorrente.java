package com.wipro.gama.bankapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tblContaCorrente")
public class ContaCorrente extends Conta implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "CC")
	@JsonIgnore
	private Cliente cliente;

	public ContaCorrente() {
	}

	public ContaCorrente(String numConta, double saldo, String numCartao) {
	this.numConta = numConta;
	this.saldo = saldo;
	this.numCartao = numCartao;
	}

	@Override
	public void saque(double value) {
		        if (value > saldo){
		            System.out.println("Saldo Insuficiente");
		        }else{
		        	double tax = 7.0;
		            saldo = saldo -(value + tax);
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
				"Numero Conta: "+numConta+"\n"+
				"Saldo atual: "+saldo);
	}

	public void transferir(double value) {
		if (value > (saldo)) {
			System.out.println("Saldo insuficiente");
		}
		else {
			saldo = saldo - value;
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}