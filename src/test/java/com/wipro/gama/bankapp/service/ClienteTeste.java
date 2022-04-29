package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.repository.ClienteRepository;
import com.wipro.gama.bankapp.service.ClienteService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@Sql(scripts = "/sql/inserirClientesTeste.sql")
@TestPropertySource(locations="classpath:application-test.properties")
public class ClienteTeste {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void criarCliente(){
        Date data = new Date(11-11-2021);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Cliente cliente = new Cliente(99,"Ezau Martins","02055574169","rua aslfato","99998888","ezau@gmail.com",data,null,null);
        clienteService.create(cliente);
        
        Cliente clienteget = clienteRepository.getById(99);

        assertNotNull(clienteget);


    }

    @Test
    public void criarVariosCliente(){
        Date data = new Date(11/11/2021);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente = new Cliente(99,"Ezau Martins","02055574169","rua aslfato","99998888","ezau@gmail.com",data,null,null);
        clienteService.create(cliente);
        Cliente cliente2 = new Cliente(99,"Ezau Martins","02055474169","rua aslfato","99998888","ezau@gmail.com",data,null,null);
        clienteService.create(cliente2);

        List<Cliente> list = clienteRepository.findAll();

        assertTrue(list.size() > 1);

    }

    @Test
    public void findByIdTeste() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente = clienteService.findById(999);
        dateFormat.format(cliente.getData_nascimento());
        assertEquals("Ezau Martins", cliente.getNome());
        assertEquals("02057468257", cliente.getCpf());
        assertEquals("Rua. São pedro", cliente.getEndereco());
        assertEquals("92982372396", cliente.getTelefone());
        assertEquals("ennif@gmail.com", cliente.getEmail());
        assertEquals("10/11/2021", dateFormat.format(cliente.getData_nascimento()));
    }

    @Test
    public void deletarClienteTeste(){
        clienteService.delete(999);
        Optional<Cliente> cliente = clienteRepository.findById(999);
        assertFalse(cliente.isPresent());
    }


}