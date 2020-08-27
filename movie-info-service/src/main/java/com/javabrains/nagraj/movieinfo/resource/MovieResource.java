package com.javabrains.nagraj.movieinfo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.nagraj.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable int movieId)
	{
		return new Movie(movieId, "Test name", "Test description");
	}
}
