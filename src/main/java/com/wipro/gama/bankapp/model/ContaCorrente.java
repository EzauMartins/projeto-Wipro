package com.wipro.gama.bankapp.model;

import org.hibernate.annotations.Cascade;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "tblContaCorrente")
public class ContaCorrente extends Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	/*@ManyToOne
	@JoinColumn(name = "cliente_id")
	Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}*/

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
		            saldo -= value + tax;
		        }
		
	}

	@Override
	public void deposito(double value) {
		this.saldo =+ value;
		
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


	
	
}