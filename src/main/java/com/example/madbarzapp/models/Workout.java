package com.example.madbarzapp.models;

import java.util.List;

import lombok.Data;

@Data
public class Workout {

	private Long id;
	private String name;
	private Long rounds;
	private Long exerciseRestSeconds;
	private Long setRestSeconds;
	private List<Exercise> exercises;	
}
