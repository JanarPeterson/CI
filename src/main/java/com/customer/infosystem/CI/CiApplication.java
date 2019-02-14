package com.customer.infosystem.CI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EntityScan("com.customer.infosystem.CI.entity")
@EnableJpaRepositories(basePackages = "com.customer.infosystem.CI.repositories")
public class CiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiApplication.class, args);

	}

}

