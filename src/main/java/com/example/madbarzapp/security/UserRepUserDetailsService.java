package com.example.madbarzapp.security;

import com.example.madbarzapp.data.UserRep;
import com.example.madbarzapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
        UserDetailsService;
import org.springframework.security.core.userdetails.
        UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserRepUserDetailsService
        implements UserDetailsService {

    private UserRep userRepo;

    @Autowired
    public UserRepUserDetailsService(UserRep userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }

}
