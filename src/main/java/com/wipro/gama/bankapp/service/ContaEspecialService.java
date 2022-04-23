package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.model.Valor;
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
    
    @Id
	int Id;
	double limiteAdicional;
	double tax = 5.0;
	
    public ContaEspecial update(Integer id, ContaEspecial obj) {
        ContaEspecial newObj = findById(id);
        newObj.setLimiteAdicional(obj.getLimiteAdicional());
      //newObj.setTax(obj.getClass());
        return repository.save(newObj);
    }


    public ContaEspecial create(ContaEspecial obj) {
        return repository.save(obj);
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

    
}
