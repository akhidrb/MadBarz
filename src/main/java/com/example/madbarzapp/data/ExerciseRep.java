package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Exercise;

public interface ExerciseRep {

    Iterable<Exercise> findAll();

    Exercise findById(Long id);

    Exercise save(Exercise exercise);

}
