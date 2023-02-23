package com.avrezzon.mealplanningcalendar.controller;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.model.user.User;
import com.avrezzon.mealplanningcalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping
    public List<User> getAllRegisteredUsers(){
        return Collections.emptyList();
    }

    @PostMapping
    public User createUser(){
        User user = new User(1, "Anthony", "Rezzonico", "anthonyrezz@gmail.com", CaloricIntake.CALORIES_2000, null, Collections.emptyList());
        return repository.save(user);
    }

}
