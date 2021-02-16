package io.akash.practice.microservices.movieinfoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDbResponseDto {
	private String id;
	private String title;
	private String overview;
	private String voteAverage;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * @param overview the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * @return the voteAverage
	 */
	public String getVoteAverage() {
		return voteAverage;
	}

	/**
	 * @param voteAverage the voteAverage to set
	 */
	@JsonProperty("vote_average")
	public void setVoteAverage(String voteAverage) {
		this.voteAverage = voteAverage;
	}
	@Override
	public String toString() {
		return "MovieDbResponseDto [id=" + id + ", title=" + title + ", overview=" + overview + ", voteAverage="
				+ voteAverage + "]";
	}
}
