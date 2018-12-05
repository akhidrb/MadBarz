package com.example.madbarzapp.models;

import java.util.List;

import lombok.Data;

@Data
public class Exercise {

	private Long id;
	private String name;
	private List<MuscleGroup> muscleGroups;
	
}
