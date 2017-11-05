package com.mvlbarcelos.movie.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mvlbarcelos.movie.Movie.TypeSubscription;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class Subscription {

	public enum Status {
		INACTIVE, ACTIVE, BLOCKED
	}

	private TypeSubscription typeSubscription;

	private Status status;

}
