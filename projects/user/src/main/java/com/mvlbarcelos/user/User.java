package com.mvlbarcelos.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	public enum Subscription {
		PREMIUM, STANDARD
	}

	@Id
	@NotNull
	private String username;
	@NotNull
	private String email;
	@NotNull
	private String name;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Subscription subscription;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
