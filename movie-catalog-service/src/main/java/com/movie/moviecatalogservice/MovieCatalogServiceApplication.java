package com.movie.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	/**
	 * Creamos un @Bean que se puede utilizar en cualquier clase con @Autowired
	 **/
	@Bean
	public RestTemplate getRestTemplate() {return new RestTemplate();}

	public static void main(String[] args) {

		SpringApplication.run(MovieCatalogServiceApplication.class, args);
		System.out.println("Servicio movie-catalog-service RUN");

	}

}
