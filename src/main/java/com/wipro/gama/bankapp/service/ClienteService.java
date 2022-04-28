package com.wipro.gama.bankapp.service;

import java.util.List;
import java.util.Optional;

import com.wipro.gama.bankapp.model.dto.AddConta;
import com.wipro.gama.bankapp.exceptionhandler.NotFoundException;
import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.model.dto.Valor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.gama.bankapp.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Cliente findById(Integer id) {   // LISTAR POR ID
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(()-> new NotFoundException());
    }
	
	public List<Cliente> findAll() {      // Retorna Todos
        return repository.findAll();
    }

    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


	public Cliente update(Integer id, Cliente obj) {
		Cliente newObj = findById(id);
	      //newObj.setTax(obj.getClass());
	        return repository.save(newObj);
	}
    public ResponseEntity<String> addConta(AddConta addConta, String tipo, Integer idCliente){
        Cliente cliente = repository.getById(idCliente);
        switch (tipo){
            case "cc":
                ContaCorrente cc = new ContaCorrente(
                    addConta.getNumConta(),addConta.getSaldo(), addConta.getNumCartao()
                );
                cliente.setCC(cc);
                repository.save(cliente);
                return ResponseEntity.status(HttpStatus.OK).body("Conta adicionada para cliente: "+cliente.getNome());
            case "ce":
                ContaEspecial ce = new ContaEspecial(
                        addConta.getNumConta(),addConta.getSaldo(),addConta.getLimiteAdicional(), addConta.getNumCartao());
                cliente.setCE(ce);
                repository.save(cliente);
                return ResponseEntity.status(HttpStatus.OK).body("Conta adicionada para cliente: "+cliente.getNome());
            default:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Link n�o encontrado");
        }

    }
    public void tranferencia(int idOrig, int idDest, Valor valor ){
       String tipoOrig = identTipoContaOrigigem(idOrig);
       String tipoDest = identTipoContaDestino(idDest);

        Cliente clienteOrig = repository.getById(idOrig);
        Cliente clienteDest = repository.getById(idDest);

        if (identTipoContaOrigigem(idOrig) == "cc" && identTipoContaDestino(idDest) == "cc" ){
            clienteOrig.getCC().transferir(valor.getValue());
            clienteDest.getCC().deposito(valor.getValue());
        } else if(identTipoContaOrigigem(idOrig) == "cc" && identTipoContaDestino(idDest) == "ce"){
            clienteOrig.getCC().transferir(valor.getValue());
            clienteDest.getCE().deposito(valor.getValue());
        } else if (identTipoContaOrigigem(idOrig) == "ce" && identTipoContaDestino(idDest) == "cc" ){
            clienteOrig.getCE().transferir(valor.getValue());
            clienteDest.getCC().deposito(valor.getValue());
        } else if(identTipoContaOrigigem(idOrig) == "ce" && identTipoContaDestino(idDest) == "ce"){
            clienteOrig.getCE().transferir(valor.getValue());
            clienteDest.getCE().deposito(valor.getValue());
        }
        repository.save(clienteOrig);
        repository.save(clienteDest);

    }

    public String identTipoContaOrigigem(int idOrig){

        Cliente clienteOrig = repository.getById(idOrig);
        String tipoOrig;

        if (clienteOrig.getCC() == null){
            tipoOrig = "ce";
        }else if (clienteOrig.getCE() == null){
            tipoOrig = "cc";
        }else {
            tipoOrig = "Usuario não possue conta";
        }

        return tipoOrig;
    }

    public String identTipoContaDestino(int idDest) {

        Cliente clienteDest = repository.getById(idDest);
        String tipoDest;

        if (clienteDest.getCC() == null){
            tipoDest = "ce";
        }else if (clienteDest.getCE() == null){
            tipoDest = "cc";
        }else {
            tipoDest = "Usuario não possue conta";
        }

        return tipoDest;
    }

}