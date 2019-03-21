package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransversalApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TransversalApplication.class, args);
		System.out.println("Servidor arrancado....");
		System.out.println("");
	}

}
