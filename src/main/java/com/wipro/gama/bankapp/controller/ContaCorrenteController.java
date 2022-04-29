package com.wipro.gama.bankapp.controller;

import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.dto.Valor;
import com.wipro.gama.bankapp.service.ContaCorrenteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacorrente")
@CrossOrigin(origins = "*")
public class ContaCorrenteController {

        @Autowired
        private ContaCorrenteService service;


        @GetMapping("/{id}")
        @ApiOperation(value = "retorna Conta Corrente por ID")
        public ResponseEntity<ContaCorrente> GetById(@PathVariable Integer id) {

            ContaCorrente CC = this.service.findById(id);
            return ResponseEntity.ok().body(CC);
        }

        @GetMapping
        @ApiOperation(value = "Retorna Lista de Conta Corrente")
        public ResponseEntity<List<ContaCorrente>> GetAll() {
            List<ContaCorrente> listCC = service.findAll();
            return ResponseEntity.ok().body(listCC);
        }

        @PostMapping("/{id}/novaconta")
        @ApiOperation(value = "Cria e adiciona Conta ao Cliente")
        public ResponseEntity<String> addConta(@PathVariable Integer id, @RequestBody ContaCorrente CC) {
            return service.addConta(CC,id);
        }

        @DeleteMapping("/{id}")
        @ApiOperation(value = "Deleta Conta")
        public ResponseEntity<Void> Delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent() .build();
        }

        @PutMapping("/{id}")
        @ApiOperation(value = "Edita Conta")
        public ResponseEntity<ContaCorrente> Put(@PathVariable Integer id, @RequestBody ContaCorrente obj) {
            ContaCorrente cc = service.update(id, obj);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cc);
        }

        @PutMapping("/{id}/deposito")
        @ApiOperation(value = "Deposita na conta")
        public ResponseEntity<String> deposito(@PathVariable Integer id, @RequestBody Valor valor) {
            ContaCorrente cc = service.deposito(id,valor);
            return ResponseEntity.status(HttpStatus.OK).body("Valor depositado, Saldo Atual  ="+cc.getSaldo());
        }

        @PutMapping("/{id}/saque")
        @ApiOperation(value = "Saca da conta")
        public ResponseEntity<String> saque(@PathVariable Integer id, @RequestBody Valor valor) {
            ContaCorrente cc = service.saque(id,valor);
            return ResponseEntity.status(HttpStatus.OK).body("Valor debitado, Saldo Atual  ="+cc.getSaldo());
        }







}
