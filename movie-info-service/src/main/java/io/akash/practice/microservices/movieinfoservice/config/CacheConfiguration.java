package io.akash.practice.microservices.movieinfoservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfiguration {	
	/*
	 * Spring uses a Lettuce connection factory by default.
	 * No need to create a separate bean for ConnectionFactory.
	 */
	
//	 @Bean
//	 RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//	   RedisTemplate< String, Object > redisTemplate =  new RedisTemplate<String, Object>();
//	   redisTemplate.setConnectionFactory(connectionFactory);
//	   redisTemplate.setKeySerializer(new StringRedisSerializer());
//	   redisTemplate.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//	   redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//	   return redisTemplate;
//	  }
	
	@Value("${spring.redis.host}")
	public String  REDIS_HOST_PROPERTY;
	
	@Value("${spring.redis.port}")
	public String  REDIS_PORT_PROPERTY;
	

//	@Bean
//	public LettuceConnectionFactory redisConnectionFactory() {
//		RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
//		System.out.println("Redis host: "+REDIS_HOST_PROPERTY);
//		System.out.println("Redis port: "+REDIS_PORT_PROPERTY);
//		redisConf.setHostName(REDIS_HOST_PROPERTY);
//		redisConf.setPort(Integer.parseInt(REDIS_PORT_PROPERTY));
//		return new LettuceConnectionFactory(redisConf);
//	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
	    JedisConnectionFactory jedisConnectionFactory
	      = new JedisConnectionFactory();
	    jedisConnectionFactory.setHostName(REDIS_HOST_PROPERTY);
	    jedisConnectionFactory.setPort(Integer.parseInt(REDIS_PORT_PROPERTY));
	    return jedisConnectionFactory;
	}
	 
	 @Bean
	 RedisTemplate<String, Object> redisTemplate() {
	   RedisTemplate< String, Object > redisTemplate =  new RedisTemplate<String, Object>();
	   redisTemplate.setConnectionFactory(redisConnectionFactory());
	   redisTemplate.setKeySerializer(new StringRedisSerializer());
	   redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	   redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
	   redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	   return redisTemplate;
	  }
	 
//	  @Bean
//		RedisTemplate<String, FinancialInformationProvider> redisTemplateMovieInfo() {
//		RedisTemplate<String, FinancialInformationProvider> redisTemplate = new RedisTemplate<String, FinancialInformationProvider>();
//			redisTemplate.setConnectionFactory(redisConnectionFactory());
//
//			redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(FinancialInformationProvider.class));
//			redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//			return redisTemplate;
//		}
}
