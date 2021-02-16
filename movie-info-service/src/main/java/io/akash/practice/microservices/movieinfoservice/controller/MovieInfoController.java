package io.akash.practice.microservices.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.akash.practice.microservices.movieinfoservice.dto.MovieInfoResponseDto;
import io.akash.practice.microservices.movieinfoservice.service.MovieInfoService;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
	
	@Autowired
	MovieInfoService movieInfoService;
	
	@RequestMapping(path="/{id}", produces="application/json")
	public ResponseEntity<MovieInfoResponseDto> getInfo(@PathVariable("id") String movieId) throws Exception{
		MovieInfoResponseDto movieInfoResponseDto = movieInfoService.getInfo(movieId);
		return new ResponseEntity<MovieInfoResponseDto>(movieInfoResponseDto, HttpStatus.OK);
	}
}
