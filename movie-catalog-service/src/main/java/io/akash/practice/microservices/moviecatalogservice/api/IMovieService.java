package io.akash.practice.microservices.moviecatalogservice.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import io.akash.practice.microservices.moviecatalogservice.dto.MovieDto;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieInfoResponseDto;

@RefreshScope
public interface IMovieService {
	public MovieInfoResponseDto getMovieInfo(MovieDto movie);
	
	public MovieInfoResponseDto getFallbackMovieInfo(MovieDto movie);
}