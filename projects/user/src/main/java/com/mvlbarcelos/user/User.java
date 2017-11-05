package com.mvlbarcelos.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@NotNull @NonNull
	private String username;
	@NotNull @NonNull
	private String email;
	@NotNull @NonNull
	private String name;
}
