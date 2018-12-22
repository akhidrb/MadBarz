package com.example.madbarzapp.models;

import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@Entity
public class Workout {

	@Id
	@GeneratedValue
	private Long id;
	private String userId;
	private String name;
	private Long rounds;
	private Long exerciseRest;
	private Long setRest;

	@ManyToMany
	private List<Exercise> exercises;

	public Workout() {
	}

	public Workout(Long id, String userId, String name, Long rounds,
				   Long exerciseRest, Long setRest) {
		this.id = id;
		this.name = name;
		this.rounds = rounds;
		this.exerciseRest = exerciseRest;
		this.setRest = setRest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRounds() {
		return rounds;
	}

	public void setRounds(Long rounds) {
		this.rounds = rounds;
	}

	public Long getExerciseRest() {
		return exerciseRest;
	}

	public void setExerciseRest(Long exerciseRest) {
		this.exerciseRest = exerciseRest;
	}

	public Long getSetRest() {
		return setRest;
	}

	public void setSetRest(Long setRest) {
		this.setRest = setRest;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
