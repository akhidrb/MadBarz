package com.example.madbarzapp.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcWorkoutRep  {

    private SimpleJdbcInsert workoutInserter;
    private JdbcTemplate jdbc;

    public  JdbcWorkoutRep() {

    }

}
