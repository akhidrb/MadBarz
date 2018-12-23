package com.example.madbarzapp.security;


import com.example.madbarzapp.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username,
                passwordEncoder.encode(password), fullname);
    }

}
