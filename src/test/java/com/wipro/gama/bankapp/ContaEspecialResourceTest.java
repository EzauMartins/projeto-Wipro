package com.wipro.gama.bankapp;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wipro.gama.bankapp.controller.ContaCorrenteController;
import com.wipro.gama.bankapp.controller.ContaEspecialController;

public class ContaEspecialResourceTest  extends BankappApplicationTests {

	
	
	//método responsável por fazer as requisiçoes de teste
			private MockMvc mookMvc;
			
			@Autowired
			private ContaEspecialController contaEspecialControle;
			
			
			@Before
			public void setUp() {
				this.mookMvc = MockMvcBuilders.standaloneSetup(contaEspecialControle).build();
			}
			
}
