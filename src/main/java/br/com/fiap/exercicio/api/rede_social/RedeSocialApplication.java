package br.com.fiap.exercicio.api.rede_social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RedeSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedeSocialApplication.class, args);
	}

}
