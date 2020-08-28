package com.javabrains.nagraj.moviecatalog.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabrains.nagraj.moviecatalog.model.CatalogItem;
import com.javabrains.nagraj.moviecatalog.model.Movie;
import com.javabrains.nagraj.moviecatalog.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{
		// different steps :
		// get all the rated movies from the rating service
		// hardcode for now
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		
		
		List<Rating> ratings = Arrays.asList(
				new Rating(121,5),
				new Rating(388,4)
				);
		
		return ratings.stream().map(rating -> {
			//get the movie object from its url
			Movie movie = restTemplate.getForObject("http://localhost:8041/movies/" + rating.getMovieId(), Movie.class);
			// bad thing 1 - hardcoding the url above (8041), it should instead discover the movie info service.
			// bad thing 2 - creating the restteplate in this main method, it will be called each time we refresh the browser.
			// 				 we instead want it to be made just once, and then used multiple times. So we should create a bean to create a singleton.
			return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
		})
			.collect(Collectors.toList());
		
		
		// for each movieId, get description from movie-info-service
		// put them all together
		
	}
}
