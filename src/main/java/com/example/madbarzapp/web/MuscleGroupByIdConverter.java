package com.example.madbarzapp.web;

import com.example.madbarzapp.data.MuscleGroupRep;
import com.example.madbarzapp.models.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MuscleGroupByIdConverter implements Converter<String, MuscleGroup> {

    private MuscleGroupRep muscleGroupRep;

    @Autowired
    public MuscleGroupByIdConverter(MuscleGroupRep muscleGroupRep) {
        this.muscleGroupRep = muscleGroupRep;
    }

    @Override
    public MuscleGroup convert(String id) {
        Long muscleId = (Long) Long.parseLong(id);
        return muscleGroupRep.findById(muscleId);
    }
}
