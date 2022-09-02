package com.movie.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient

public class MovieCatalogServiceApplication {

	/**
	 * Creamos un @Bean que se puede utilizar en cualquier clase con @Autowired
	 *
	 * Con @LoadBalnced decimos la url que te damos no es la directa al servicio llamdo.
	 * la etiqueta se encarga de encotrar el servicio
	 **/
	@Bean
	@LoadBalanced //Para implementar server - discovery
	public RestTemplate getRestTemplate() {return new RestTemplate();}

	public static void main(String[] args) {

		SpringApplication.run(MovieCatalogServiceApplication.class, args);
		System.out.println("Servicio movie-catalog-service RUN");

	}

}
