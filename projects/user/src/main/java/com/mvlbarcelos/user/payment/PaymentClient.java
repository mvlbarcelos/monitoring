package com.mvlbarcelos.user.payment;

import com.mvlbarcelos.user.User;
import com.mvlbarcelos.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class PaymentClient {

	private final RestTemplate restTemplate;

	private final UserRepository repository;

	private final PaymentConfigurationProperties paymentConfigurationProperties;
	
	public UserSubscription userSubscription(String username) {

		User user = repository.findOne(username);
		String url = String.format("%s%s", paymentConfigurationProperties.getUrl(), username);
		Subscription subscription = restTemplate.getForObject(url, Subscription.class);
		return new UserSubscription(user, subscription);
	}
}
