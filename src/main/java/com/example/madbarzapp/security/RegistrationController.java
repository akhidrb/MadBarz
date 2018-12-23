package com.example.madbarzapp.security;


import com.example.madbarzapp.data.UserRep;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRep userRep;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRep userRep,
                                  PasswordEncoder passwordEncoder) {
        this.userRep = userRep;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registratioForm() {
        return "registration";
    }

    @PostMapping
    public String registerUser(RegistrationForm form) {
        userRep.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }


}
