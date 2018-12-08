package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Workout;

public interface WorkoutRep {

    Iterable<Workout> findAll();

    Workout findById(Long id);

    Workout save(Workout workout);

    String queryWorkout = "Select w.id, w.name, wd.rounds," +
            "wd.exerciserest, wd.setrest " +
            "from Workout w " +
            "left join workout_data wd " +
            "on w.id=wd.id";

}
