package edu.eci.is.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("edu.eci.is.registro.entities")
@EnableJpaRepositories("edu.eci.is.registro.repositories")
@SpringBootApplication
public class RegistroApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RegistroApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RegistroApplication.class, args);
	}

}
