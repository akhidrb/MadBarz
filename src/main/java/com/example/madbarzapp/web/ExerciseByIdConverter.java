package com.example.madbarzapp.web;

import com.example.madbarzapp.data.ExerciseRep;
import com.example.madbarzapp.models.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseByIdConverter implements Converter<String, Exercise> {

    private ExerciseRep exerciseRep;

    @Autowired
    public ExerciseByIdConverter(ExerciseRep exerciseRep) {
        this.exerciseRep = exerciseRep;
    }

    @Override
    public Exercise convert(String id) {
        Long exerciseId = (Long) Long.parseLong(id);
        return exerciseRep.findById(exerciseId);
    }

}