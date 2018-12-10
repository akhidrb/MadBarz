package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRep extends CrudRepository<Exercise, Long> {

}
