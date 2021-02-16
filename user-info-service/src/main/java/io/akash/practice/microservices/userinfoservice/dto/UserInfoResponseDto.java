package io.akash.practice.microservices.userinfoservice.dto;

import java.util.List;

import io.akash.practice.microservices.userinfoservice.model.MovieModel;

public class UserInfoResponseDto {
	private String name;
	private List<MovieModel> movies;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the movies
	 */
	public List<MovieModel> getMovies() {
		return movies;
	}
	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<MovieModel> movies) {
		this.movies = movies;
	}
	
	
}
