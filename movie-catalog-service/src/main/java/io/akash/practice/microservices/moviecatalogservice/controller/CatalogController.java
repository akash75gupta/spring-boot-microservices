package io.akash.practice.microservices.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.akash.practice.microservices.moviecatalogservice.api.IMovieService;
import io.akash.practice.microservices.moviecatalogservice.api.IUserService;
import io.akash.practice.microservices.moviecatalogservice.dto.CatalogResponseDto;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieDto;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieInfoResponseDto;
import io.akash.practice.microservices.moviecatalogservice.dto.UserInfoResponseDto;
import io.akash.practice.microservices.moviecatalogservice.model.CatalogItemModel;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	@Autowired
	IUserService userService;
	
	@Autowired
	IMovieService movieService;

	@RequestMapping(path="/{id}", produces="application/json")
	public CatalogResponseDto getCatalog(@PathVariable("id") String userId) {
		CatalogResponseDto movieCatalogDto = new CatalogResponseDto();
		
		UserInfoResponseDto userInfoResponseDto = userService.getUserInfo(userId); 
		List<MovieDto> movies = userInfoResponseDto.getMovies();
		
		List<CatalogItemModel> catalog = movies.stream().map(movie->{
			MovieInfoResponseDto movieInfoResponseDto = movieService.getMovieInfo(movie);
			System.out.println("#################################################################");
			System.out.println("############## Movie Response DTO: "+movieInfoResponseDto);
			System.out.println("#################################################################");
			CatalogItemModel catalogItemModel = new CatalogItemModel(	movie.getId(), 
																		movieInfoResponseDto.getName(), 
																		movieInfoResponseDto.getDescription(), 
																		movie.getRating());
		    return catalogItemModel;
		}).collect(Collectors.toList());
		
		movieCatalogDto.setCatalog(catalog);
		return movieCatalogDto;
	}
}
