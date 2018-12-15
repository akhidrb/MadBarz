package com.example.madbarzapp.data;

import com.example.madbarzapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
