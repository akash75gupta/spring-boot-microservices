package io.akash.practice.microservices.moviecatalogservice.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import io.akash.practice.microservices.moviecatalogservice.dto.UserInfoResponseDto;

@RefreshScope
public interface IUserService {
	public UserInfoResponseDto getUserInfo(String userId);
	
	public UserInfoResponseDto getFallbackUserInfo(String userId);
	
}
