package io.akash.practice.microservices.userinfoservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.akash.practice.microservices.userinfoservice.dto.UserInfoResponseDto;
import io.akash.practice.microservices.userinfoservice.model.MovieModel;
import io.akash.practice.microservices.userinfoservice.model.UserModel;

@RestController
@RequestMapping("/users")
public class UserInfoController {
	
	@RequestMapping(path="/{id}", produces="application/json")
	public UserInfoResponseDto getInfo(@PathVariable("id")String userId) {
		UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto();
		UserModel user = new UserModel(
								userId, 
							  "Akash", 
							  List.of(new MovieModel("123", 4.5), new MovieModel("550",3.0))
						 );
		userInfoResponseDto.setName(user.getName());
		userInfoResponseDto.setMovies(user.getMovies());
		
		return userInfoResponseDto;
	}
}
