package com.example.madbarzapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Musclegroup")
public class Musclegroup {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Musclegroup() {
	}

	public Musclegroup(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Musclegroup(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
