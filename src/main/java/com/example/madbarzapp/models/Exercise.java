package com.example.madbarzapp.models;

import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@Entity
public class Exercise {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany
	private List<Musclegroup> musclegroups;

	public Exercise() {
	}

	public Exercise(Long id, String name) {
		this.id = id;
		this.name = name;
	}

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

	public List<Musclegroup> getMusclegroups() {
		return musclegroups;
	}

	public void setMusclegroups(List<Musclegroup> musclegroups) {
		this.musclegroups = musclegroups;
	}

}
