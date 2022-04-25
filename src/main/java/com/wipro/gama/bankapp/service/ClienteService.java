package com.wipro.gama.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.gama.bankapp.model.Cliente;
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

    //FAZER UPDATE

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
