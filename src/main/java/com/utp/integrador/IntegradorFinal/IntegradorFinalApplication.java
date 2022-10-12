package com.utp.integrador.IntegradorFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/mysql/db.properties")
public class IntegradorFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorFinalApplication.class, args);
	}

}
