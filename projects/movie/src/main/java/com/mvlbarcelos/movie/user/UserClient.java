package com.mvlbarcelos.movie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.url}")
	private String URL;

	public UserSubscription getSubscription(String username) {
		UserSubscription userSubscription = restTemplate.getForObject(
				String.format("%s%s/subscription",URL, username), UserSubscription.class);
		
		return userSubscription;
	}
}
