package com.wipro.gama.bankapp.service;

import java.util.List;
import java.util.Optional;

import com.wipro.gama.bankapp.model.dto.AddConta;
import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.gama.bankapp.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Cliente findById(Integer id) {   // LISTAR POR ID
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);
    }
	
	public List<Cliente> findAll() {      // Retorna Todos
        return repository.findAll();
    }

    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public ResponseEntity<String> addConta(AddConta addConta, String tipo, Integer idCliente){
        Cliente cliente = repository.getById(idCliente);
        switch (tipo){
            case "cc":
                ContaCorrente cc = new ContaCorrente(
                    addConta.getNumConta(),addConta.getSaldo(), addConta.getNumCartao()
                );
                cliente.setCC(cc);
                repository.save(cliente);
                return ResponseEntity.status(HttpStatus.OK).body("Conta adicionada para cliente: "+cliente.getNome());
            case "ce":
                ContaEspecial ce = new ContaEspecial(
                        addConta.getNumConta(),addConta.getSaldo(),addConta.getLimiteAdicional(), addConta.getNumCartao());
                cliente.setCE(ce);
                repository.save(cliente);
                return ResponseEntity.status(HttpStatus.OK).body("Conta adicionada para cliente: "+cliente.getNome());
            default:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Link não encontrado");
        }

    }

}
