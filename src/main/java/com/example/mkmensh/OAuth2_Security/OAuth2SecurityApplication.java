package com.example.mkmensh.OAuth2_Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class OAuth2SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SecurityApplication.class, args);
	}

}
