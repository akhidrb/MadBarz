package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRep extends CrudRepository<Workout, Long> {

}
