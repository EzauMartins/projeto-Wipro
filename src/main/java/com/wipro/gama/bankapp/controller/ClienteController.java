package com.wipro.gama.bankapp.controller;

import com.wipro.gama.bankapp.model.dto.AddConta;
import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/criarconta")
    public ResponseEntity<String> AddConta(@PathVariable Integer id, @RequestBody AddConta addconta, @RequestParam String tipo) {
        return service.addConta(addconta, tipo, id);
    }

}
