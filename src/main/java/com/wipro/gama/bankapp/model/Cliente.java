package com.wipro.gama.bankapp.model;


import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3144270426459686871L;
	
	@Id
	//IDENTITY GERA ID AUTOMATICO NO BANCO
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cpf;
	private String endereco;
	@Column(name ="nome completo")
	private String nome;
	private String telefone;
	private String email;
	private String data_nascimento;
@Table(name = "tblCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column (nullable = false , length = 100)
    private String nome;

	public Cliente(int id, String cpf, String endereco, String nome, String telefone, String email,
			String data_nascimento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.data_nascimento = data_nascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
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

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<ContaCorrente> CC = new ArrayList<>();

    public List<ContaCorrente> getCC() {
        return CC;
    }

    /* @OneToMany(
                cascade = CascadeType.ALL
        )
        //@JoinColumn(name="contaEspecialId")
        private List<ContaEspecial> CE = new ArrayList<>();
    */
    //==============================================
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

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
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
