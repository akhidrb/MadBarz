package com.example.madbarzapp.data;

import com.example.madbarzapp.models.MuscleGroup;

public interface MuscleGroupRep {

	Iterable<MuscleGroup> findAll();
	
	MuscleGroup findById(Long id);

}
