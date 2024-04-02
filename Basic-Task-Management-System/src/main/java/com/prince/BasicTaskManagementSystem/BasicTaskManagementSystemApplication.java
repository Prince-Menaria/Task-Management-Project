package com.prince.BasicTaskManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicTaskManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicTaskManagementSystemApplication.class, args);
	}

}
