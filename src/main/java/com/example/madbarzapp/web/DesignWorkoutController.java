package com.example.madbarzapp.web;

import com.example.madbarzapp.data.CriteriaExerciseRep;
import com.example.madbarzapp.data.ExerciseRep;
import com.example.madbarzapp.data.WorkoutRep;
import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class DesignWorkoutController {

    private final WorkoutRep workoutRep;
    private final ExerciseRep exerciseRep;
    private CriteriaExerciseRep criteriaExerciseRep;

    @Autowired
    public DesignWorkoutController(WorkoutRep workoutRep,
                                   ExerciseRep exerciseRep,
                                   CriteriaExerciseRep criteriaExerciseRep) {
        this.workoutRep = workoutRep;
        this.exerciseRep = exerciseRep;
        this.criteriaExerciseRep = criteriaExerciseRep;
    }

    @ModelAttribute(name = "workout")
    public Workout workout() {
        return new Workout();
    }

    @RequestMapping(value="/workout", method = RequestMethod.GET)
    public String showDesignForm(Model model) {
        List<Exercise> exerciseArrayList = new ArrayList<>();
        exerciseRep.findAll().forEach(exercise -> exerciseArrayList.add(exercise));
        model.addAttribute("exercises", exerciseArrayList.stream().collect(Collectors.toList()));

        List<Exercise> exerciseList = new ArrayList<>();
        criteriaExerciseRep.findExercisesByName("up")
                .forEach(exercise -> exerciseList.add(exercise));
        model.addAttribute("exByName", exerciseList.stream().collect(Collectors.toList()));
        return "design-workout";
    }

    @RequestMapping(value="/workout", method = RequestMethod.POST)
    public String processDesign(Workout workout) {
        Workout saved = workoutRep.save(workout);
        return "redirect:/workout";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String displayWorkout(Model model) {
        List<Workout> workouts = new ArrayList<>();
        workoutRep.findAll().forEach(workout -> workouts.add(workout));
        model.addAttribute("workouts", workouts);
        return "home";
    }


}





