package com.revashare.theatmbackend;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.Transaction;
import com.revashare.theatmbackend.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class TheAtmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheAtmBackendApplication.class, args);
	}

}
