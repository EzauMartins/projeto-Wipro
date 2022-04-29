package com.wipro.gama.bankapp.controller;

import com.wipro.gama.bankapp.model.dto.AddConta;
import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.dto.Valor;
import com.wipro.gama.bankapp.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@Api(value="API REST Clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Clientes")
    public ResponseEntity<Cliente> GetById(@PathVariable Integer id) {
        Cliente CC = this.service.findById(id);
        return ResponseEntity.ok().body(CC);
    }

    @GetMapping
    @ApiOperation(value = "Retorna Lista Clientes")
    public ResponseEntity<List<Cliente>> GetAll() {
        List<Cliente> listCliente = service.findAll();
        return ResponseEntity.ok().body(listCliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> Post(@Valid @RequestBody  Cliente CC) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CC));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente nCliente = service.update(id, cliente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(nCliente);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta Clientes")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/criarconta")
    @ApiOperation(value = "Adiciona Conta a Clientes")
    public ResponseEntity<String> AddConta(@PathVariable Integer id, @RequestBody AddConta addconta, @RequestParam String tipo) {
        return service.addConta(addconta, tipo, id);
    }


    @PutMapping("/{idorig}/tranferir/{iddest}")
    public  ResponseEntity<String> Tranferir(@PathVariable Integer idorig, @PathVariable Integer iddest,@RequestBody Valor valor) {
       return service.tranferencia(idorig,iddest,valor);
    }



}
