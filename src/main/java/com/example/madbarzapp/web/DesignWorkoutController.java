package com.example.madbarzapp.web;

import com.example.madbarzapp.data.ExerciseRep;
import com.example.madbarzapp.data.UserRep;
import com.example.madbarzapp.data.WorkoutRep;
import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.User;
import com.example.madbarzapp.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class DesignWorkoutController {

    private final WorkoutRep workoutRep;
    private final ExerciseRep exerciseRep;
    private UserRep userRep;

    @Autowired
    public DesignWorkoutController(WorkoutRep workoutRep,
                                   ExerciseRep exerciseRep,
                                   UserRep userRep) {
        this.workoutRep = workoutRep;
        this.exerciseRep = exerciseRep;
        this.userRep = userRep;
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
        return "design-workout";
    }

    @RequestMapping(value="/workout", method = RequestMethod.POST)
    public String processDesign(Workout workout, Principal principal) {

        workout.setUserId(getUserId(principal));
        Workout saved = workoutRep.save(workout);

        return "redirect:/workout";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String displayWorkout(Model model, Principal principal) {

        List<Workout> workouts = new ArrayList<>();
        String username = getUserId(principal);
        if (username != null) {
            workoutRep.findAllByUserId(username)
                    .forEach(workout -> workouts.add(workout));
        }
        model.addAttribute("workouts", workouts);
        return "home";
    }


    private String getUserId(Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userRep.findByUsername(username);
            return user.getUsername();
        }
        return null;
    }


}





