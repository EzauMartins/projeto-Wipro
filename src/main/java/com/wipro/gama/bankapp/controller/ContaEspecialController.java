package com.wipro.gama.bankapp.controller;

import java.util.List;

import com.wipro.gama.bankapp.model.dto.Valor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.service.ContaEspecialService;

@RestController
@RequestMapping("/contaespecial")
@CrossOrigin(origins = "*")
public class ContaEspecialController {
	
		@Autowired
		private ContaEspecialService service;
	
	 	@GetMapping("/{id}")
	    public ResponseEntity<ContaEspecial> GetById(@PathVariable Integer id) { 

		 	ContaEspecial obj = this.service.findById(id);
	        return ResponseEntity.ok().body(obj);
	    }

	    @GetMapping
	    public ResponseEntity<List<ContaEspecial>> GetAll() {
	        List<ContaEspecial> list = service.findAll();
	        return ResponseEntity.ok().body(list);
	    }

		@PostMapping("/{id}/novaconta")
		public ResponseEntity<String> addConta(@PathVariable Integer id, @RequestBody ContaEspecial CE) {
			return service.addConta(CE,id);
		}

		@PutMapping("/{id}/portabidade")
		public ResponseEntity<String> portablidade(@PathVariable Integer id, @RequestBody Valor valor) {
			return service.portabalidade(valor,id);
		}


		@PutMapping("/{id}")
		public ResponseEntity<ContaEspecial> Put(@PathVariable Integer id, @RequestBody ContaEspecial ce) {
			ContaEspecial updateCe = service.update(id, ce);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCe);

		}

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }

		@PutMapping("/{id}/deposito")
		public ResponseEntity<String> deposito(@PathVariable Integer id, @RequestBody Valor valor) {
			ContaEspecial ce = service.deposito(id,valor);
			return ResponseEntity.status(HttpStatus.OK).body("Valor depositado, Saldo Atual  ="+ce.getSaldo());
		}

		@PutMapping("/{id}/saque")
		public ResponseEntity<String> saque(@PathVariable Integer id, @RequestBody Valor valor) {
			ContaEspecial ce = service.saque(id,valor);
			return ResponseEntity.status(HttpStatus.OK).body("Valor debitado, Saldo Atual  ="+ce.getSaldo());
		}

	

	
}
