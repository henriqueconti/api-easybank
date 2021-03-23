package br.com.easybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybankApplication.class, args);
	}

}
