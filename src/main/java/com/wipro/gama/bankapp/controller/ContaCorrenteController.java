package com.wipro.gama.bankapp.controller;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ContaCorrete")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteService service;


    @GetMapping("/{id}")
    public ResponseEntity<ContaCorrente> GetById(@PathVariable Integer id) {

        ContaCorrente CC = this.service.findById(id);
        return ResponseEntity.ok().body(CC);
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> GetAll() {
        List<ContaCorrente> listCC = service.findAll();
        return ResponseEntity.ok().body(listCC);
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> Post(@RequestBody ContaCorrente CC) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CC));
    }
    //FAZER UPDATE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaCorrente> Put(@PathVariable Integer id, @RequestBody ContaCorrente obj) {
        ContaCorrente cc = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cc);
    }


}
