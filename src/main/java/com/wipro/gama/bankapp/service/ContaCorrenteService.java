package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.List;
import java.util.Optional;

@Service
public class ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository repository;

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

    //FAZER UPDATE

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

