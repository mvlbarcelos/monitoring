package com.mvlbarcelos.movie;

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
public class Movie {

	public enum TypeSubscription {
		PREMIUM, STANDARD
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	private UUID uuid;
	
	@NotNull @NonNull
	private String title;

	@Enumerated(EnumType.STRING)
	@NotNull @NonNull
	private TypeSubscription typeSubscription;
}
