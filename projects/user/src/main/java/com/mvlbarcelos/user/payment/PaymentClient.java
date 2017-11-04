package com.mvlbarcelos.user.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mvlbarcelos.user.User;
import com.mvlbarcelos.user.UserRepository;

@Component
public class PaymentClient {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository repository;
	
	@Value("${payment.url}")
	private String URL;

	public UserSubscription userSubscription(String username) {

		User user = repository.findOne(username);
		String url = String.format("%s%s",URL, username);
		Subscription subscription = restTemplate.getForObject(url, Subscription.class);
		return new UserSubscription(user, subscription);
	}
}
