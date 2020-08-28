package com.javabrains.nagraj.rating.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.nagraj.rating.model.Rating;
import com.javabrains.nagraj.rating.model.UserRatings;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
	@GetMapping("/movies/{movieId}")
	public Rating getrating(@PathVariable int movieId)
	{
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatings getRatingByUser(@PathVariable String userId)
	{
		UserRatings userRatings = new UserRatings();
		userRatings.initData(userId);
		return userRatings;			
	}

}
