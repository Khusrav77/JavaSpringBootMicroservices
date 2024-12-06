package com.shh.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImp")
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST API Documentation",
				description = "EazyBank Account microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Safiev Khusrav",
						email = "shh85b@gmail.com",
						url = "www.linkedin.com/in/khusrav-safiev"
				),
				license = @License(
						name = "Apache 2.0",
						url = "www.linkedin.com/in/khusrav-safiev"
				)
		),
		externalDocs = @ExternalDocumentation(
				     description = "EazyBank Account microservice REST API Documentation",
					 url = "swagger-ui.html"
				)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
