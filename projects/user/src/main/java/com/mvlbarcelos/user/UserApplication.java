package com.mvlbarcelos.user;

import com.mvlbarcelos.user.payment.PaymentConfigurationProperties;
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
@EnableConfigurationProperties({UserConfigurationProperties.class, PaymentConfigurationProperties.class})
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
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
	public CommandLineRunner initDb(UserConfigurationProperties userConfigurationProperties,
									UserRepository userRepository) {
		if (!userConfigurationProperties.isInitDb()) {
			return null;
		} else {
			return strings -> Stream.of(new User("marcus", "marcus@test.com", "Marcus"),
					new User("jonh", "jonh@test.com", "Jonh"),
					new User("paul", "paul@test.com", "Paul")).forEach(
					m -> userRepository.save(m)
			);
		}
	}
}
