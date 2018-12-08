package com.example.madbarzapp.models;

import lombok.Data;

@Data
public class MuscleGroup {

	private final Long id;
	private final String name;

	public MuscleGroup(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
