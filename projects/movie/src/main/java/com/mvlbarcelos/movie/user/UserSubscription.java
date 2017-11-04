package com.mvlbarcelos.movie.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSubscription {

	private User user;
	private Subscription subscription;

	@JsonCreator
	public UserSubscription(@JsonProperty("user")User user, @JsonProperty("subscription")Subscription subscription) {
		this.user = user;
		this.subscription = subscription;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public User getUser() {
		return user;
	}

}
