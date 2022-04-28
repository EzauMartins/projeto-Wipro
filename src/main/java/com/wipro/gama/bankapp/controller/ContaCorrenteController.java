package com.wipro.gama.bankapp.controller;

import java.util.List;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.dto.Valor;
import com.wipro.gama.bankapp.service.ContaCorrenteService;

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

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.service.ContaCorrenteService;

@RestController
@RequestMapping("/contacorrente")
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

        /* @PostMapping
          public ResponseEntity<ContaCorrente> Post(@RequestBody ContaCorrente CC) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CC));
         }*/

        @PutMapping("/{id}/novaconta")
        public ResponseEntity<String> addConta(@PathVariable Integer id, @RequestBody ContaCorrente CC) {
            return service.addConta(CC,id);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> Delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent() .build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<ContaCorrente> Put(@PathVariable Integer id, @RequestBody ContaCorrente obj) {
            ContaCorrente cc = service.update(id, obj);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cc);
        }

        @PutMapping("/{id}/deposito")
        public ResponseEntity<String> deposito(@PathVariable Integer id, @RequestBody Valor valor) {
            ContaCorrente cc = service.deposito(id,valor);
            return ResponseEntity.status(HttpStatus.OK).body("Valor depositado, Saldo Atual  ="+cc.getSaldo());
        }

        @PutMapping("/{id}/saque")
        public ResponseEntity<String> saque(@PathVariable Integer id, @RequestBody Valor valor) {
            ContaCorrente cc = service.saque(id,valor);
            return ResponseEntity.status(HttpStatus.OK).body("Valor debitado, Saldo Atual  ="+cc.getSaldo());
        }

	   





}