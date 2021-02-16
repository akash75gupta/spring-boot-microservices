package io.akash.practice.microservices.moviecatalogservice.dto;

import java.util.List;

public class UserInfoResponseDto {
	private String name;
	private List<MovieDto> movies;

	public UserInfoResponseDto(String name, List<MovieDto> movies) {
		super();
		this.name = name;
		this.movies = movies;
	}
	
	public UserInfoResponseDto() {
		super();
	}

	public List<MovieDto> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<MovieDto> movies) {
		this.movies = movies;
	}

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

}
