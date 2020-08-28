package com.javabrains.nagraj.moviecatalog.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabrains.nagraj.moviecatalog.model.CatalogItem;
import com.javabrains.nagraj.moviecatalog.model.Movie;
import com.javabrains.nagraj.moviecatalog.model.Rating;
import com.javabrains.nagraj.moviecatalog.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{
		// different steps :
		// get all the rated movies from the rating service
		
		// bad thing 3 : its complex to set the responseType to List<Rating>, in the getForObject method.
		//List<Rating> ratings = restTemplate.getForObject("https://localhost:8043/rating/users/" + userId, responseType)
		
		//UserRatings ratings = restTemplate.getForObject("http:")
		UserRatings ratings = restTemplate.getForObject("http://ratings-service/rating/users/" + userId, UserRatings.class);
		
		return ratings.getUserRatings().stream().map(rating -> {
			//get the movie object from its url
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			// bad thing 1 - hardcoding the url above (8041), it should instead discover the movie info service.
			return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
		})
			.collect(Collectors.toList());
		
		
		// for each movieId, get description from movie-info-service
		// put them all together
		
	}
}
