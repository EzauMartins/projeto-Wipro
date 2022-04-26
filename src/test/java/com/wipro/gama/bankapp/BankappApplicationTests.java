package com.wipro.gama.bankapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = BankappApplication.class)
@RunWith(SpringRunner.class)
@TestPropertySource(locations ="classpath:application.properties")
class BankappApplicationTests {

	@Test
	void contextLoads() {
	}

}
