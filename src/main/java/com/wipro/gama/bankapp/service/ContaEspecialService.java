package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.repository.ContaEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaEspecialService {

    @Autowired
    ContaEspecialRepository repository;
}
