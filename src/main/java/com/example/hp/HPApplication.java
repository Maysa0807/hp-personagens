package com.example.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class HPApplication {
	public static void main(String[] args) {
		SpringApplication.run(HPApplication.class, args);
	}

}
