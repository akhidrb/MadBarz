package com.example.madbarzapp.web;

import com.example.madbarzapp.data.ExerciseRep;
import com.example.madbarzapp.data.MusclegroupRep;
import com.example.madbarzapp.data.UserRep;
import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.Musclegroup;
import com.example.madbarzapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/exercise")
public class DesignExerciseController {

    private final MusclegroupRep muscleGroupRep;
    private final ExerciseRep exerciseRep;
    private UserRep userRep;

    @Autowired
    public DesignExerciseController(MusclegroupRep muscleGroupRep,
                                    ExerciseRep exerciseRep,
                                    UserRep userRep) {
        this.muscleGroupRep = muscleGroupRep;
        this.exerciseRep = exerciseRep;
        this.userRep = userRep;
    }

    @ModelAttribute(name = "exercise")
    public Exercise exercise() {
        return new Exercise();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        List<Musclegroup> musclegroupList = new ArrayList<>();
        muscleGroupRep.findAll().forEach(musclegroup -> musclegroupList.add(musclegroup));
        model.addAttribute("musclegroups", musclegroupList.stream().collect(Collectors.toList()));

        String username = principal.getName();
        User user = userRep.findByUsername(username);
        model.addAttribute("user", user);

        return "design-exercise";
    }

    @PostMapping
    public String processDesign(Exercise exercise) {
        Exercise saved = exerciseRep.save(exercise);
        return "redirect:/exercise";
    }

}
