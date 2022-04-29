package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.repository.ClienteRepository;
import com.wipro.gama.bankapp.repository.ContaCorrenteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@Sql(scripts = "/sql/inserirContaCorrenteTeste.sql")
@TestPropertySource(locations="classpath:application-test.properties")
public class ContaCorrenteTeste {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;
    @Autowired
    ContaCorrenteService contaCorrenteService;
    @Autowired
    ClienteService clienteService;

    @Test
    public void createCC() {

        ContaCorrente cc = new ContaCorrente("5555444433332222",100.00,"565689896");
        contaCorrenteService.addConta(cc,999);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente = clienteService.findById(999);
        dateFormat.format(cliente.getData_nascimento());
        assertEquals("Ezau Martins", cliente.getNome());
        assertEquals("02057468257", cliente.getCpf());
        assertEquals("Rua. São pedro", cliente.getEndereco());
        assertEquals("92982372396", cliente.getTelefone());
        assertEquals("ennif@gmail.com", cliente.getEmail());
        assertEquals("10/11/2021", dateFormat.format(cliente.getData_nascimento()));
        //GET CONTA
        assertEquals("5555444433332222",cliente.getCC().getNumConta());
        assertEquals(100.00,cliente.getCC().getSaldo(),1);
        assertEquals("565689896",cliente.getCC().getNumCartao());

    }

    @Test
    public void findByIdCC() {
        ContaCorrente cc = contaCorrenteService.findById(1001);

        assertEquals("2222444455556666", cc.getNumCartao());
        assertEquals("69358247", cc.getNumConta());
        assertEquals(150.00, cc.getSaldo(),1);

    }

    @Test
    public void deletarCC(){
        contaCorrenteService.delete(1001);

        Optional<ContaCorrente> cc = contaCorrenteRepository.findById(1001);
        assertFalse(cc.isPresent());
    }


}