package com.javabrains.nagraj.rating.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.nagraj.rating.model.Rating;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
	@GetMapping("/{movieId}")
	public Rating getrating(@PathVariable int movieId)
	{
		return new Rating(movieId, 4);
	}

}
