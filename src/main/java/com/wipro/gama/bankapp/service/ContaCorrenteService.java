package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.controller.ContaCorrenteController;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.repository.ContaCorrenteRepository;
import com.wipro.gama.bankapp.repository.ContaEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository repository;


    public ContaCorrente findById(Integer id){   // LISTAR POR ID
        Optional<ContaCorrente> CC = repository.findById(id);
        return CC.orElse(null);
    }

    public List<ContaCorrente> findAll(){       // Retorna Todos
        return repository.findAll();
    }


  /*

    public Clientes update(Integer id, Clientes obj) {
        Clientes newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setSobrenome(obj.getSobrenome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);
    }

    public Clientes create(Clientes obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }*/


}
