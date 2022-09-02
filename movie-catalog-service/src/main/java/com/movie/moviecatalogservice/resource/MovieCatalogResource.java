package com.movie.moviecatalogservice.resource;

import com.movie.moviecatalogservice.models.CatalogItem;
import com.movie.moviecatalogservice.models.Movie;
import com.movie.moviecatalogservice.models.UserRating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    //Inyección de dependencia de un bean (in main)
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}")
    @CircuitBreaker(name = "prueba",fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){


        /**
         * 1. Petición al servidor Rating data service con la clave userId
         * 2. Obtenemos un objeto tipo UserRAting - List<rating> del userId
         **/
        //UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
        System.out.println("http://rating-data-service/ratingsdata/users/" + userId);
        UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);


        /**
         * 1. Recorremos los elementos de la lista ratings que se supone que viene del servicio: rating data service
         *
         * 2. Por cada rating hacemos una REQUEST --> Moving info Srvice dado el movieId obtenido de rating.getMovieId() obtenemos
         *    El objeto movie al que corresponde que nos devuelve - movieID
         *
         *                                                        - name
         * 3. Creamos una instacia CatalogItem donde asignamos:   - name -->movie.getName()
         *                                                        - descrip --> ponemos la descp que queramos
         *                                                        - rating --> rating.getRating()
         **/
        return userRating.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),Movie.class);
                    return new CatalogItem(movie.getName(),"description of movieId --> " + rating.getMovieId(),rating.getRating());
                }).collect(Collectors.toList());//Generamos una listta

    }
    //Si existe un circuito cerrado entramos aquí
    public List<CatalogItem> getFallbackCatalog(Exception e){
        return Arrays.asList(new CatalogItem("no movie", "", 0));
    }
}
