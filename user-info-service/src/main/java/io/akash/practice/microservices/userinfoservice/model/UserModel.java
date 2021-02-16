package io.akash.practice.microservices.userinfoservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-account")
public class UserModel {
	private String id;
	private String name;
	private List<MovieModel> movies;
	
	public UserModel(String id, String name, List<MovieModel> movies) {
		super();
		this.id = id;
		this.name = name;
		this.setMovies(movies);
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
