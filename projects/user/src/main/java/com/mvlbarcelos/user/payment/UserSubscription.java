package com.mvlbarcelos.user.payment;

import com.mvlbarcelos.user.User;

public class UserSubscription {

	private User user;
	private Subscription subscription;

	public UserSubscription(User user, Subscription subscription) {
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
