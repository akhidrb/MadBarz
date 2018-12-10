package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Workout;

public interface WorkoutRep {

    Iterable<Workout> findAll();

    Workout findById(Long id);

    Workout save(Workout workout);

    String queryExercises = "Select e.* " +
            "from workout_exercise we " +
            "left join exercise e " +
            "on we.exerciseid=e.id " +
            "where we.workoutid = ?";

    String queryWorkout = "Select w.id, w.name, wd.rounds," +
            "wd.exerciserest, wd.setrest " +
            "from Workout w " +
            "left join workout_data wd " +
            "on w.id=wd.id";

//    String queryWorkout = "Select w.id, w.name, wd.rounds, wd.exerciserest, wd.setrest, " +
//            "(select e.name from exercise e where e.id=we.exerciseid) as exerciseName " +
//            "from Workout w " +
//            "left join workout_data wd " +
//            "on w.id=wd.id " +
//            "left join workout_exercise we " +
//            "on we.workoutid=w.id";

}
