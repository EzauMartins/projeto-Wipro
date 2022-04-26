package com.wipro.gama.bankapp;

import static org.mockito.ArgumentMatchers.matches;

import java.util.Date;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.MediaType;
import com.wipro.gama.bankapp.controller.ClienteController;
import com.wipro.gama.bankapp.model.Cliente;
import com.wipro.gama.bankapp.model.ContaCorrente;
import com.wipro.gama.bankapp.model.ContaEspecial;

public class ClienteResourceTest  extends BankappApplicationTests{

	
	//método responsável por fazer as requisiçoes de teste
	private MockMvc mookMvc;
	
	@Autowired
	private ClienteController clienteControle;
	
	
	@Before
	public void setUp() {
		this.mookMvc = MockMvcBuilders.standaloneSetup(clienteControle).build();
	}
	
	@Test
	public void criarCliente_RetornarStatusCode201() throws Exception {
		
		Date data = new Date();
		Cliente cliente = new Cliente(null,"ezau","02057716770","rua x m x","8888-8888","ezau@98.com", data,null,null);

		
		//convertendo objeto para json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cliente);
		
		
		//fazendo requisição
		this.mookMvc.perform(MockMvcRequestBuilders.post("/Clientes")
							.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
							.content(json)
							)
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.header()
		.stringValues("location", Matchers.contains("https://localhost/clientes")));
			
		
	}
}
