package io.akash.practice.microservices.movieinfoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableCaching
public class MovieInfoServiceApplication {
	
	@Value("${api.timeout}")
	Integer timeout;
	
	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory 
											= new HttpComponentsClientHttpRequestFactory();
		System.out.println("###########################");
		System.out.println("##### Setting a timeout of "+timeout+"ms");
		System.out.println("###########################");

		httpComponentsClientHttpRequestFactory.setConnectTimeout(timeout);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}
}
