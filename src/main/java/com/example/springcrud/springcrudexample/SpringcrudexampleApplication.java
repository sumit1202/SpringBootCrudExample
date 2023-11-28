package com.example.springcrud.springcrudexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcrudexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudexampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("=> Command line runner executed <=");
		};
	}

}
