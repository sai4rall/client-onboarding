package com.example.client_onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClientOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientOnboardingApplication.class, args);
	}

}
