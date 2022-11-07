package com.revashare.theatmbackend;


import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.Transaction;
import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.services.AccountService;
import com.revashare.theatmbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class TheAtmBackendApplication {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TheAtmBackendApplication.class, args);
	}



}
