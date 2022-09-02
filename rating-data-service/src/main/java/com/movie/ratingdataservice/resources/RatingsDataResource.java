package com.movie.ratingdataservice.resources;

import com.movie.ratingdataservice.models.Rating;
import com.movie.ratingdataservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

        @RequestMapping("/{movieId}")
        public Rating getRating(@PathVariable("movieId") String movieId){
            return new Rating(movieId,4);
        }

        @RequestMapping("users/{userId}")
        public UserRating getUserRating(@PathVariable("userId") String userId){
            //Get all rated movie IDs
            List<Rating> ratings = Arrays.asList(
                    new Rating("550", 4),
                    new Rating("550",3),
                    new Rating("550", 1)
            );
            //Esto lo hacemos para devolver un objeto en vez de una lista de objetos
            UserRating userRating = new UserRating(ratings);

            return userRating;
        }

}
