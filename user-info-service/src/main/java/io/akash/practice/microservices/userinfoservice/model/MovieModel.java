package io.akash.practice.microservices.userinfoservice.model;


public class MovieModel {
	private String id;
	private Double rating;
	
	public MovieModel(String id, Double rating) {
		super();
		this.id = id;
		this.rating = rating;
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
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}
		
}
