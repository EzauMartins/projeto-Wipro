package com.wipro.gama.bankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tblHistoricoTransferencia")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String clienteOrigem, clienteDestino;

    private double valor;

    @JsonIgnore
    LocalDateTime data = LocalDateTime.now();


    public Historico() {
    }

    public Historico(Integer id, String clienteOrigem, String clienteDestino, double valor, LocalDateTime data) {
        this.id = id;
        this.clienteOrigem = clienteOrigem;
        this.clienteDestino = clienteDestino;
        this.valor = valor;
        this.data = data;
    }


    // ====== GET/SET ======
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClienteOrigem() {
        return clienteOrigem;
    }

    public void setClienteOrigem(String clienteOrigem) {
        this.clienteOrigem = clienteOrigem;
    }

    public String getClienteDestino() {
        return clienteDestino;
    }

    public void setClienteDestino(String clienteDestino) {
        this.clienteDestino = clienteDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
