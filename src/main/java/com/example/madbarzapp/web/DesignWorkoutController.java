package com.example.madbarzapp.web;

import com.example.madbarzapp.data.ExerciseRep;
import com.example.madbarzapp.data.MuscleGroupRep;
import com.example.madbarzapp.data.WorkoutRep;
import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/workout")
public class DesignWorkoutController {

    private final WorkoutRep workoutRep;
    private final ExerciseRep exerciseRep;

    @Autowired
    public DesignWorkoutController(WorkoutRep workoutRep,
                                    ExerciseRep exerciseRep) {
        this.workoutRep = workoutRep;
        this.exerciseRep = exerciseRep;
    }

    @ModelAttribute(name = "workout")
    public Workout workout() {
        return new Workout();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Exercise> exerciseArrayList = new ArrayList<>();
        exerciseRep.findAll().forEach(exercise -> exerciseArrayList.add(exercise));
        model.addAttribute("exercises", exerciseArrayList.stream().collect(Collectors.toList()));
        return "design-workout";
    }

    @PostMapping
    public String processDesign(Workout workout) {
        Workout saved = workoutRep.save(workout);
        return "redirect:/";
    }


}
