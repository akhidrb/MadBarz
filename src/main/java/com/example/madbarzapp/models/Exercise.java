package com.example.madbarzapp.models;

import java.util.List;

import lombok.Data;

@Data
public class Exercise {

	private Long id;
	private String name;
	private List<MuscleGroup> muscleGroups;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MuscleGroup> getMuscleGroups() {
		return muscleGroups;
	}

	public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
		this.muscleGroups = muscleGroups;
	}

}
