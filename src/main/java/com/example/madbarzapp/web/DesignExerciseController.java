package com.example.madbarzapp.web;

import com.example.madbarzapp.data.MuscleGroupRep;
import com.example.madbarzapp.models.Exercise;
import com.example.madbarzapp.models.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DesignExerciseController {

    private final MuscleGroupRep muscleGroupRep;

    @Autowired
    public DesignExerciseController(MuscleGroupRep muscleGroupRep) {
        this.muscleGroupRep = muscleGroupRep;
    }

    @ModelAttribute(name = "exercise")
    public Exercise exercise() {
        return new Exercise();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<MuscleGroup> muscleGroupList = new ArrayList<>();
        muscleGroupRep.findAll().forEach(muscleGroup -> muscleGroupList.add(muscleGroup));
        model.addAttribute("musclegroups", muscleGroupList);
        return "design-exercise";
    }


}
