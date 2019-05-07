package com.accounting.currencies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrenciesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CurrenciesApplication.class, args);
	}


}
