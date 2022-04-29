package com.wipro.gama.bankapp.service;

import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;
import com.wipro.gama.bankapp.repository.ContaCorrenteRepository;
import com.wipro.gama.bankapp.repository.ContaEspecialRepository;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@Sql(scripts = "/sql/inserirContaEspecialTeste.sql")
@TestPropertySource(locations="classpath:application-test.properties")
public class ContaEspecialTeste {

    @Autowired
    ContaEspecialRepository contaEspecialRepository;
    @Autowired
    ContaEspecialService contaEspecialService;
    @Autowired
    ClienteService clienteService;


    @Test
    public void createCE() {

        ContaEspecial ce = new ContaEspecial("5555444433332222",100.00,50.00,"565689896");
        contaEspecialService.addConta(ce,999);

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
        assertEquals("5555444433332222",cliente.getCE().getNumConta());
        assertEquals(100.00,cliente.getCE().getSaldo(),1);
        assertEquals("565689896",cliente.getCE().getNumCartao());
        assertEquals(50.00,cliente.getCE().getLimiteAdicional(),1);

    }


    @Test
    public void findByIdCE() {
        ContaEspecial ce = contaEspecialService.findById(1002);

        assertEquals("2222444455556666", ce.getNumCartao());
        assertEquals("69358247", ce.getNumConta());
        assertEquals(150.00, ce.getSaldo(),1);
        assertEquals(100.00, ce.getLimiteAdicional(),1);
        assertEquals(5, ce.getTax(),1);

    }

    @Test
    public void deletarCE(){
        contaEspecialService.delete(1002);

        Optional<ContaEspecial> ce = contaEspecialRepository.findById(1002);
        assertFalse(ce.isPresent());
    }




}