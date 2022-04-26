package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.model.dto.Valor;
import com.wipro.gama.bankapp.repository.ClienteRepository;
import com.wipro.gama.bankapp.repository.ContaEspecialRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContaEspecialService {

    @Autowired
    ContaEspecialRepository repository;

    @Autowired
    ClienteRepository clienteRepository;
    
    
    public ContaEspecial findById(Integer id) {
        Optional<ContaEspecial> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<ContaEspecial> findAll() {
        return repository.findAll();
    }

    public ContaEspecial create(ContaEspecial obj) {
        return repository.save(obj);
    }

    public ContaEspecial update(Integer id, ContaEspecial ce){
        ContaEspecial updatece = findById(id);
        updatece = ce;
        return repository.save(updatece);
    }
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public ContaEspecial deposito(Integer id, Valor valor){
        ContaEspecial ce = findById(id);
        ce.deposito(valor.getValue());
        return repository.save(ce);
    }

    public ContaEspecial saque(Integer id, Valor valor) {
        ContaEspecial ce = findById(id);
        ce.saque(valor.getValue());
        return repository.save(ce);
    }

    public ResponseEntity<String> addConta(ContaEspecial newCE, Integer idCliente){
        Cliente cliente = clienteRepository.getById(idCliente);
        cliente.setCE(newCE);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Conta especial adicionada para cliente: "+cliente.getNome());

    }


    
}