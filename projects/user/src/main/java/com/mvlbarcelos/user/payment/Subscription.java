package com.mvlbarcelos.user.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class Subscription {

	public enum Type {
		PREMIUM, STANDARD
	}

	public enum Status {
		INACTIVE, ACTIVE, BLOCKED
	}

	private Type type;

	private Status status;
}
