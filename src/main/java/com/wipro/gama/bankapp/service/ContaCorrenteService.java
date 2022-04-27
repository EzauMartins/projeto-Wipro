package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.dto.Valor;
import com.wipro.gama.bankapp.repository.ClienteRepository;
import com.wipro.gama.bankapp.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository repository;

    @Autowired
    ClienteRepository clienteRepository;

    public ContaCorrente findById(Integer id) {   // LISTAR POR ID
        Optional<ContaCorrente> CC = repository.findById(id);
        return CC.orElse(null);
    }

    public List<ContaCorrente> findAll() {      // Retorna Todos
        return repository.findAll();
    }

    public ContaCorrente create(ContaCorrente CC) {
        return repository.save(CC);
    }

    public ContaCorrente update(Integer id, ContaCorrente cc){
        ContaCorrente updatecc;
        updatecc = cc;
        updatecc.setId(id);
        return repository.save(updatecc);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public ContaCorrente deposito(Integer id, Valor valor){
        ContaCorrente cc = findById(id);
        cc.deposito(valor.getValue());
        return repository.save(cc);
    }

    public ContaCorrente saque(Integer id, Valor valor) {
        ContaCorrente cc = findById(id);
        cc.saque(valor.getValue());
        return repository.save(cc);
    }

    public ResponseEntity<String> addConta(ContaCorrente newCC, Integer idCliente){
        Cliente cliente = clienteRepository.getById(idCliente);
        cliente.setCC(newCC);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Conta adicionada para cliente: "+cliente.getNome());

    }
}

