package com.mvlbarcelos.user.payment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

	public enum Type {
		PREMIUM, STANDARD
	}

	public enum Status {
		INACTIVE, ACTIVE, BLOCKED
	}

	private Type type;

	private Status status;

	@JsonCreator
	public Subscription(@JsonProperty("type") Type type, @JsonProperty("status") Status status) {
		this.type = type;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public Type getType() {
		return type;
	}
}
