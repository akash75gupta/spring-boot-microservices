package io.akash.practice.microservices.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.akash.practice.microservices.moviecatalogservice.api.IMovieService;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieDto;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieInfoResponseDto;

@Service
public class MovieService implements IMovieService {
	@Autowired
	RestTemplate restTemplate;
	/*
	 * There are three ways to retrieve values from a property file
	 * 1.) @Value
	 * 2.) @ConfigProperties
	 * 3.) Environment Object
	 */
	@Autowired
	Environment env;

	@Override	
	@HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
	public MovieInfoResponseDto getMovieInfo(MovieDto movie) {
		System.out.println("#################################################################");
		System.out.println("Getting movie info for "+movie);
		System.out.println("#################################################################");
		MovieInfoResponseDto movieInfoResponseDto 
			= restTemplate.getForObject("http://"+env.getProperty("app.name.movie-info")+"/movies/"+ movie.getId(), MovieInfoResponseDto.class);
		return movieInfoResponseDto;
	}
	
	@Override
	public MovieInfoResponseDto getFallbackMovieInfo(MovieDto movie) {
		System.out.println("#################################################################");
		System.out.println("Get fallback movie info for "+movie);
		System.out.println("#################################################################");
		return new MovieInfoResponseDto("N/A", "N/A", "N/A");
	}
}
