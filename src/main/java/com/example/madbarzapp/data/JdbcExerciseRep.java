package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.MuscleGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class JdbcExerciseRep implements ExerciseRep {

    private SimpleJdbcInsert exerciseInsert;
    private ObjectMapper objectMapper;
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcExerciseRep(JdbcTemplate jdbc) {
        this.exerciseInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Exercise")
                .usingGeneratedKeyColumns("id");
        this.objectMapper = new ObjectMapper();
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Exercise> findAll() {
        String query = "Select * from Exercise";
        return jdbc.query(query, this::mapRowToExercise);
    }

    @Override
    public Exercise findById(Long id) {
        String query = "Select * from Exercise where id=?";
        return jdbc.queryForObject(query, this::mapRowToExercise, id);
    }

    @Override
    public Exercise save(Exercise exercise) {
        Long exerciseId = saveInExerciseDB(exercise);
        for (MuscleGroup muscleGroup: exercise.getMuscleGroups()) {
            saveInExerciseMuscleGroup(exerciseId, muscleGroup.getId());
        }
        return exercise;
    }

    private void saveInExerciseMuscleGroup(Long exerciseId, Long muscleGroupId) {
        String query = "INSERT INTO Exercise_MuscleGroup(exerciseId, "
                + "muscleGroupID) values (?, ?)";
        jdbc.update(query, exerciseId, muscleGroupId);

    }

    private Long saveInExerciseDB(Exercise exercise) {
        Map<String, Object> values =
                objectMapper.convertValue(exercise, Map.class);
        long exerciseId =
                exerciseInsert
                        .executeAndReturnKey(values)
                        .longValue();
        return exerciseId;
    }

    private Exercise mapRowToExercise(ResultSet rs,
                                      int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Exercise(id, name);
    }



}
