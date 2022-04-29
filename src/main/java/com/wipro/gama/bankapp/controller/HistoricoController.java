package com.wipro.gama.bankapp.controller;


import com.wipro.gama.bankapp.model.Historico;
import com.wipro.gama.bankapp.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historico")
@CrossOrigin(origins = "*")
public class HistoricoController {

    @Autowired
    HistoricoService historicoService;

    @GetMapping
    public ResponseEntity<List<Historico>> GetAll() {
        List<Historico> list = historicoService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
