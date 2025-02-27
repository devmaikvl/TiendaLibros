package com.libros.TiendaLibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.libros.TiendaLibros.Repository")
@EntityScan(basePackages = "com.libros.TiendaLibros.model")
public class TiendaLibrosApplication {
	public static void main(String[] args) {
		SpringApplication.run(TiendaLibrosApplication.class, args);
	}
}
