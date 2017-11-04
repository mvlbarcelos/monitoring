package com.mvlbarcelos.movie.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvlbarcelos.movie.Movie.TypeSubscription;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

	public enum Status {
		INACTIVE, ACTIVE, BLOCKED
	}

	private TypeSubscription typeSubscription;

	private Status status;

	@JsonCreator
	public Subscription(@JsonProperty("type") TypeSubscription typeSubscription,
			@JsonProperty("status") Status status) {
		this.typeSubscription = typeSubscription;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public TypeSubscription getTypeSubscription() {
		return typeSubscription;
	}
}
