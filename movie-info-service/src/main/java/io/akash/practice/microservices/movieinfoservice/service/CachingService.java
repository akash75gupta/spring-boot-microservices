package io.akash.practice.microservices.movieinfoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import io.akash.practice.microservices.movieinfoservice.dto.MovieInfoResponseDto;

@Service
public class CachingService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private HashOperations<String, String, MovieInfoResponseDto> hashOps;
	
	public void saveMovieInfo(String movieId, MovieInfoResponseDto movieInfoResponseDto) {
		System.out.println("Saving movieInfo in cache for movie id: "+movieId);
		hashOps = redisTemplate.opsForHash();
		hashOps.put("movieInfo", movieId, movieInfoResponseDto);
	}
	
	public Optional<MovieInfoResponseDto> getMovieInfo(String movieId) throws Exception {
		System.out.println("Getting movieInfo from cache for movie id: "+movieId);
		hashOps = redisTemplate.opsForHash();
		return Optional.ofNullable((MovieInfoResponseDto)hashOps.get("movieInfo", movieId));
	}
}
