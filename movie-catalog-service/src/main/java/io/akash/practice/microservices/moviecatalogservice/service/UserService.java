package io.akash.practice.microservices.moviecatalogservice.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.akash.practice.microservices.moviecatalogservice.api.IUserService;
import io.akash.practice.microservices.moviecatalogservice.dto.MovieDto;
import io.akash.practice.microservices.moviecatalogservice.dto.UserInfoResponseDto;

@Service
public class UserService implements IUserService{
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired 
	EurekaClient eurekaClient;
	
	@Value("${app.name.user-info}")
	String userInfoApp;
	
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackUserInfo")
	public UserInfoResponseDto getUserInfo(String userId) {
		/*
		 * For more control over eureka client and load balancing:
		 * Application application = eurekaClient.getApplication("user-info-service");
		 * InstanceInfo instanceInfo = application.getInstances().get(0);
		 * String ipAddress = instanceInfo.getIPAddr();
		 * int port = instanceInfo.getPort();
		 * String url = "http://"+ipAddress+":"+port+"/users/";
		 * UserInfoResponseDto userInfoResponseDto = restTemplate.getForObject(url+userId, UserInfoResponseDto.class);
		*/
		UserInfoResponseDto userInfoResponseDto = restTemplate.getForObject("http://"+userInfoApp+"/users/"+userId, UserInfoResponseDto.class);
		return userInfoResponseDto;
	}
	
	@Override
	public UserInfoResponseDto getFallbackUserInfo(String userId) {
		return new UserInfoResponseDto("N/A",new ArrayList<>(Arrays.asList(new MovieDto("N/A",0.0))));
	}
}
