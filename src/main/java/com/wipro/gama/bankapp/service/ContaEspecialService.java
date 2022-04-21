package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.repository.ContaEspecialRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaEspecialService {

    @Autowired
    ContaEspecialRepository repository;
    
    
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
    
}
