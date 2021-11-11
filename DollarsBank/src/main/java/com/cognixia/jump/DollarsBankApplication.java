package com.cognixia.jump;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognixia.jump.repository.CustomerRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class DollarsBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarsBankApplication.class, args);
	}

}
