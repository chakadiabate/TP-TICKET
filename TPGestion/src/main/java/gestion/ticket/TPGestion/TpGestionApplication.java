package gestion.ticket.TPGestion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Bienvenue",
				version = "1.0.0",
				description = "Projet de gestion de ticket",
				termsOfService = "Ticket",
				contact = @Contact(
						name = "Mr Diabaté",
						email = "cdiabate801@gmail.com"
				),
				license = @License(
						name = "licence",
						url = "cdiabate801"
		)
		)
)
public class TpGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpGestionApplication.class, args);
	}

}
