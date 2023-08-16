package io.fam.sqlsecure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@SpringBootApplication
public class SqlsecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlsecureApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
		  
		};
	}

}
