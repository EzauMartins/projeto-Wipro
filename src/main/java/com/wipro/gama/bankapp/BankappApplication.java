package com.wipro.gama.bankapp;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.gama.bankapp.model.Cliente;

@SpringBootApplication
public class BankappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	
	
		Cliente cli1 = new Cliente(1,"aleff","vdsvs","vvvv","4554","fs@","4444");
		Cliente cli2 = new Cliente(1,"joao","vdsvs","vvvv","4554","fs@","4444");
		Cliente cli3 = new Cliente(1,"maria","vdsvs","vvvv","4554","fs@","4444");
		Cliente cli4 = new Cliente(1,"fsdasdf","vdsvs","vvvv","4554","fs@","4444");
		
		EntityManagerFactory  enf = Persistence.createEntityManagerFactory("cliente");
		EntityManager en = enf.createEntityManager();
		en.getTransaction();
		en.persist(cli1);
		en.persist(cli2);
		en.persist(cli3);
		en.persist(cli4);
		en.getTransaction().commit();
		
		
		
		System.out.println(cli1);
		System.out.println(cli2);
		System.out.println(cli3);
		System.out.println(cli4);
		en.close();// fecha o entity manager
		enf.close();//fecha o entity manager factory
		
		
	}

}

