package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.Historico;
import com.wipro.gama.bankapp.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    HistoricoRepository historicoRepository;

    public void registrarNovaTransacao(Historico hs){
        historicoRepository.save(hs);
    }

    public List<Historico> findAll() {      // Retorna Todos
        return historicoRepository.findAll();
    }


}
