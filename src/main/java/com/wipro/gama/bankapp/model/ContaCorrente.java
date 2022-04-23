package com.wipro.gama.bankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

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

	public void transferencia(ContaCorrente cc, ContaEspecial ce){

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