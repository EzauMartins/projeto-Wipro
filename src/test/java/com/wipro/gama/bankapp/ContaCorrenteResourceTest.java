package com.wipro.gama.bankapp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wipro.gama.bankapp.controller.ClienteController;
import com.wipro.gama.bankapp.controller.ContaCorrenteController;

public class ContaCorrenteResourceTest  extends BankappApplicationTests {

	
	
	//método responsável por fazer as requisiçoes de teste
		private MockMvc mookMvc;
		
		@Autowired
		private ContaCorrenteController contaCorrenteControle;
		
		
		@Before
		public void setUp() {
			this.mookMvc = MockMvcBuilders.standaloneSetup(contaCorrenteControle).build();
		}
		
		
}
