package com.mvlbarcelos.movie;

import com.mvlbarcelos.movie.user.UserConfigurationProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties({MovieConfigurationProperties.class, UserConfigurationProperties.class})
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}

	@Bean
	public CommandLineRunner initDb(MovieConfigurationProperties movieConfigurationProperties, MovieRepository movieRepository) {
		if (!movieConfigurationProperties.isInitDb()) {
			return null;
		} else {
			return strings -> Stream.of(new Movie("Training Day", Movie.TypeSubscription.PREMIUM),
					new Movie("The Godfather", Movie.TypeSubscription.PREMIUM),
					new Movie("E.T. the Extra-Terrestrial", Movie.TypeSubscription.PREMIUM),
					new Movie("Saving Private Ryan", Movie.TypeSubscription.STANDARD),
					new Movie("Braveheart", Movie.TypeSubscription.STANDARD)).forEach(
					m -> movieRepository.save(m)
			);
		}
	}
}

