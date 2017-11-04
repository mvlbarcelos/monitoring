package com.mvlbarcelos.movie;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Movie {

	public enum TypeSubscription {
		PREMIUM, STANDARD
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	private UUID uuid;
	
	@NotNull
	private String title;

	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeSubscription typeSubscription;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TypeSubscription getTypeSubscription() {
		return typeSubscription;
	}

	public void setTypeSubscription(TypeSubscription typeSubscription) {
		this.typeSubscription = typeSubscription;
	}
}
