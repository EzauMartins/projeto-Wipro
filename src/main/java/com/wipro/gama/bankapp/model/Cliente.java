package com.wipro.gama.bankapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tblCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false , length = 100)
    private String nome;

    @Size(min = 11,max = 11)
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column (nullable = false, length = 50)
    private String endereco;

    @Column (nullable = false , length = 12)
    private String telefone;

    @Column (nullable = false , length = 50)
    private String email;

    @Column (nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_nascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name ="clinte_cc",
            joinColumns = {@JoinColumn(name = "cliente_id" )},
            inverseJoinColumns = {@JoinColumn(name = "cc_id")})
    private ContaCorrente CC;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name ="clinte_ce",
            joinColumns = {@JoinColumn(name = "cliente_id" )},
            inverseJoinColumns = {@JoinColumn(name = "ce_id")})
    private ContaEspecial CE;



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


    // ====== GET/SET ======

    public ContaCorrente getCC() {
        return CC;
    }

    public void setCC(ContaCorrente CC) {
        this.CC = CC;
    }

    public ContaEspecial getCE() {
        return CE;
    }

    public void setCE(ContaEspecial CE) {
        this.CE = CE;
    }

    public Cliente() {
        super();
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
