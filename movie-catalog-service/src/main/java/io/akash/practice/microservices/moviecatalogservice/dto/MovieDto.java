package io.akash.practice.microservices.moviecatalogservice.dto;

public class MovieDto {
	private String id;
	private Double rating;

	public MovieDto() {
		super();
	}
	
	public MovieDto(String id, Double rating) {
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

	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", rating=" + rating + "]";
	}
}
