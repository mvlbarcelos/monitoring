package com.mvlbarcelos.movie.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class UserClient {

	private final RestTemplate restTemplate;

	private final UserConfigurationProperties configurationProperties;

	public UserSubscription getSubscription(String username) {
		UserSubscription userSubscription = restTemplate.getForObject(
				String.format("%s%s/subscription", configurationProperties.getUrl(), username), UserSubscription.class);
		return userSubscription;
	}
}
