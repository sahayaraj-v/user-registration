package com.example.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.userregistration.repository")
@EntityScan("com.example.userregistration.model")
@SpringBootApplication
public class UserRegistrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}
}
