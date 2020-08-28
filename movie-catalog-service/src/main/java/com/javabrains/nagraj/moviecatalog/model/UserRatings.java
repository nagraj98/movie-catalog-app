package com.javabrains.nagraj.moviecatalog.model;

import java.util.List;

public class UserRatings {

	private String userId;
	private List<Rating> userRatings;
	
	public UserRatings(List<Rating> userRatings, String userId) {
		super();
		this.userRatings = userRatings;
		this.userId = userId;
	}

	public UserRatings() {
		super();
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
}
