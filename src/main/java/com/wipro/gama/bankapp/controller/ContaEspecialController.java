package com.wipro.gama.bankapp.controller;

import java.util.List;

import com.wipro.gama.bankapp.model.ContaCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.service.ContaEspecialService;

@RestController
@RequestMapping("/contaespecial")

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

		@PostMapping
		public ResponseEntity<ContaEspecial> Post(@RequestBody ContaEspecial ce) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.create(ce));
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

	
	
	
}
