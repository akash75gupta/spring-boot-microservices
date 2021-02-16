# spring-boot-microservices
Practice microservices using Spring Boot and Spring Cloud. Demo example - A group of sample microservices that forms a movie ratings application.

1.) config-service:
A standalone microservice that stores application configurations remotely using Spring Cloud.

2.) discovery-service
A standalone microservice(discovery server) that enables all the microservices in a cluster of microservices to discover each other. Created using Netflix Eureka Server.

3.) movie-catalog-service
A standalone microservice that aggregates movie rating data from other microservices for given users. Use Redis for caching API call. Uses Netflix Eureka Client for communicating with the Discovery Server. ses Netflix Hysterix to implement Circuit Breaker Design Pattern for increased resilience.

4.) movie-info-service
A standalone microservice that gets movie information from an external open source data respository TMDB(moviedb.org) through API calls. Uses Spring RestTemplate as Http Client for making remote API calls. Uses Redis for caching user data retrieved from DB. Uses NoSQL Mongo DB for storing user data. Uses Netflix Eureka Client for communicating with the Discovery Server. ses Netflix Hysterix to implement Circuit Breaker Design Pattern for increased resilience.
To Do:
-Use Non-blocking Http Clients like WebClient or OkHttp3 for making asynchronous APIs calls instead of RestTemplate.

5.) user-info-service
A standalone microservice that pulls user data from the user account database. Uses Redis for caching user data retrieved from DB. Uses NoSQL Mongo DB for storing user data. Uses Netflix Eureka Client for communicating with the Discovery Server. Uses Netflix Hysterix to implement Circuit Breaker Design Pattern for increased resilience.

Work In Progress:
6.) authentication-service:
JWT Token based authentication and OAUTH 2.0 for authorization between microservices.
