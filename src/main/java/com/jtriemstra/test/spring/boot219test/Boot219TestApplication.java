package com.jtriemstra.test.spring.boot219test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class Boot219TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot219TestApplication.class, args);
	}

	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
