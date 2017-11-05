package com.mvlbarcelos.movie.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private String username;
	private String email;
	private String name;

	@JsonCreator
	public User(@JsonProperty("username")String username, @JsonProperty("email")String email, @JsonProperty("name")String name) {
		this.username = username;
		this.email = email;
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
}
