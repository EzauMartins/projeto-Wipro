package com.wipro.gama.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> GetById(@PathVariable Integer id) {

        Cliente CC = this.service.findById(id);
        return ResponseEntity.ok().body(CC);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> GetAll() {
        List<Cliente> listCliente = service.findAll();
        return ResponseEntity.ok().body(listCliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> Post(@RequestBody Cliente CC) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CC));
    }
    //FAZER UPDATE
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> Put(@PathVariable Integer id, @RequestBody Cliente obj) {
        Cliente newUsuario = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}