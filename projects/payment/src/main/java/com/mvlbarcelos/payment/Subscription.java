package com.mvlbarcelos.payment;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Subscription {

	public enum Type {
		PREMIUM, STANDARD
	}

	public enum Status {
		INACTIVE, ACTIVE, BLOCKED
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	private UUID uuid;


	@NonNull
	private String username;

	@Enumerated(EnumType.STRING)
	@NotNull @NonNull
	private Type type;

	@Enumerated(EnumType.STRING)
	@NotNull @NonNull
	private Status status;
}
