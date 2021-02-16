package io.akash.practice.microservices.movieinfoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.akash.practice.microservices.movieinfoservice.dto.MovieDbResponseDto;
import io.akash.practice.microservices.movieinfoservice.dto.MovieInfoResponseDto;

@Service
public class MovieInfoService {	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CachingService cachingService;
	
	@Value("${api.url}")
	String url;
	
	@Value("${api.endpoint.movies}")
	String endpoint;
	
	@Value("${api.key}")
	String apiKey;
	
	@HystrixCommand(fallbackMethod = "getFallbackInfo")
	public MovieInfoResponseDto getInfo(String movieId) throws Exception {
		System.out.println("#################################################################");
		System.out.println("Executing MovieInfoService.getInfo()\nGetting info for: " + movieId);
		System.out.println("#################################################################");

		MovieInfoResponseDto movieInfoResponseDto = null;
		Optional<MovieInfoResponseDto> cacheEntry = Optional.empty();
		
		cacheEntry = cachingService.getMovieInfo(movieId);
	
		if (cacheEntry.isPresent()) {
			System.out.println("Movie Info found in cache");
			movieInfoResponseDto = cacheEntry.get();
			System.out.println(movieInfoResponseDto);
		} else {
			System.out.println("Movie Info not found in cache");
			movieInfoResponseDto = new MovieInfoResponseDto();
			String completeUrl = url + endpoint + "/" + movieId + "?api_key=" + apiKey;
			System.out.println("Calling url:" + completeUrl);

			MovieDbResponseDto movieDbResponseDto = restTemplate.getForObject(completeUrl, MovieDbResponseDto.class);
			System.out.println("Response retrieved from Movie DB:" + movieDbResponseDto);

			movieInfoResponseDto.setName(movieDbResponseDto.getTitle());
			movieInfoResponseDto.setDescription(movieDbResponseDto.getOverview());
			movieInfoResponseDto.setOverallRating(movieDbResponseDto.getVoteAverage());
			
			System.out.println("Saving movie info to cache");
			try {
			cachingService.saveMovieInfo(movieId, movieInfoResponseDto);
			}catch(RuntimeException e) {
				System.out.println(e);
			}
		}

		return movieInfoResponseDto;
	}
	
	public MovieInfoResponseDto getFallbackInfo(String movieId, Throwable e) {
		System.out.println("#################################################################");
		System.out.println("Get fallback info for: "+movieId);
		System.out.println("#################################################################");
		e.printStackTrace();
		return new MovieInfoResponseDto("N/A", "N/A", "N/A");
	}
}
