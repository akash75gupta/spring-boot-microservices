package io.akash.practice.microservices.movieinfoservice.dto;

public class MovieInfoResponseDto {
	private String name;
	private String description;
	private String overallRating;
	
	public MovieInfoResponseDto(String name, String description, String overallRating) {
		super();
		this.name = name;
		this.description = description;
		this.overallRating = overallRating;
	}
	
	public MovieInfoResponseDto() {
		
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the overallRating
	 */
	public String getOverallRating() {
		return overallRating;
	}
	/**
	 * @param overallRating the overallRating to set
	 */
	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}
	@Override
	public String toString() {
		return "MovieInfoResponseDto [name=" + name + ", description=" + description + ", overallRating="
				+ overallRating + "]";
	}
}
