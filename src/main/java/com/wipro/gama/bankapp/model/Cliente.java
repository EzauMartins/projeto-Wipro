package com.wipro.gama.bankapp.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente {

	@Id
	private Integer id;
	private String cpf;
	private String endereco;
	private String nome;
	private String telefone;
	private String email;
	private Date data_nascimento;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String cpf, String endereco, String nome, String telefone, String email,
			Date data_nascimento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.data_nascimento = data_nascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", endereco=" + endereco + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", data_nascimento=" + data_nascimento + "]";
	}

}
