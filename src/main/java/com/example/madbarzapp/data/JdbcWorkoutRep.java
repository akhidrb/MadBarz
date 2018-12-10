package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.Workout;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcWorkoutRep implements WorkoutRep {

    private SimpleJdbcInsert workoutInsert;
    private ObjectMapper objectMapper;
    private JdbcTemplate jdbc;

    public  JdbcWorkoutRep(JdbcTemplate jdbc) {
        this.workoutInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Workout")
                .usingGeneratedKeyColumns("id");
        this.objectMapper = new ObjectMapper();
        this.jdbc = jdbc;
    }

    public Iterable<Workout> findAll() {
        Iterable<Workout> workouts = jdbc.query(queryWorkout, this::mapRowToWorkout);
        for(Workout workout: workouts) {
            Iterable<Exercise> exercises = jdbc.query(queryExercises, this::mapRowToExercise, workout.getId());
            List<Exercise> exercisesList = new ArrayList<>();
            exercises.forEach(exercisesList::add);
            workout.setExercises(exercisesList);
        }
        return workouts;
    }

    public Workout findById(Long id) {
        String query = queryWorkout + " where id = ?";
        return jdbc.queryForObject(query, this::mapRowToWorkout, id);
    }

    public Workout save(Workout workout) {
        Long workoutId = saveToWorkoutDB(workout);
        saveToWorkoutExerciseDB(workoutId, workout);
        saveToWorkoutDataDB(workoutId, workout);
        return workout;
    }

    private void saveToWorkoutDataDB(Long workoutId, Workout workout) {
        String query = "Insert into Workout_Data(id, rounds, " +
                "exerciserest, setrest) " +
                "values (?, ?, ?, ?)";
        jdbc.update(query, workoutId, workout.getRounds(),
                workout.getExerciseRest(), workout.getSetRest());
    }

    private void saveToWorkoutExerciseDB(Long workoutId,
                                         Workout workout) {
        String query = "Insert into Workout_Exercise(workoutId, exerciseId) " +
                "values(?,?)";
        for (Exercise exercise: workout.getExercises()) {
            jdbc.update(query, workoutId, exercise.getId());
        }
    }

    private Long saveToWorkoutDB(Workout workout) {
        Map<String, Object> values =
                objectMapper.convertValue(workout, Map.class);
        return workoutInsert.executeAndReturnKey(values)
                .longValue();
    }

    private Exercise mapRowToExercise(ResultSet rs,
                                      int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Exercise(id, name);
    }

    private Workout mapRowToWorkout(ResultSet rs,
                                    int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Long rounds = rs.getLong("rounds");
        Long exerciseRest = rs.getLong("exerciserest");
        Long setRest = rs.getLong("setrest");
        return new Workout(id, name, rounds, exerciseRest, setRest);
    }




}
