package com.movie.movieinfoservice.resource;

import com.movie.movieinfoservice.models.Movie;
import com.movie.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {


    @Value("${api.key}")
    private String ApiKey;

    @Autowired
    private RestTemplate restTemplate;

    RestTemplate restTemplate2 = new RestTemplate();


    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        /**LLamada api externa movie DB
         *  Ejemplo:  https://api.themoviedb.org/3/movie/550?api_key=a7adb99eca5402e216dc5e901996bd8d
         *  Con ResTemplate me da error debido a que el Eureka me deniega el acceso.
         **/
        System.out.println("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  ApiKey);
        MovieSummary movieSummary = restTemplate2.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  ApiKey, MovieSummary.class);


        return new Movie(movieId, movieSummary.getTitle());

    }
}
