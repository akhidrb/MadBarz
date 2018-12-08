package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Workout;

public interface WorkoutRep {

    Iterable<Workout> findAll();

    Workout findById(Long id);

    Workout save(Workout workout);

}
