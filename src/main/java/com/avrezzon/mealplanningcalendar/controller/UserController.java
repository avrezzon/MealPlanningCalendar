package com.avrezzon.mealplanningcalendar.controller;

import com.avrezzon.mealplanningcalendar.dto.UserDto;
import com.avrezzon.mealplanningcalendar.exception.ResourceNotFoundException;
import com.avrezzon.mealplanningcalendar.model.user.User;
import com.avrezzon.mealplanningcalendar.repository.UserRepository;
import com.avrezzon.mealplanningcalendar.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserManagementService service;
    private final UserRepository repository;

    @GetMapping
    public List<User> getAllRegisteredUsers() {
        log.info("Retreiving all of the registered users");
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User findUser(@PathVariable String username){
        log.info("Searching for user with username of {}", username);
        return repository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));
    }

    @PostMapping
    public User createUser(@RequestBody UserDto user) {
        log.info("Received request to register user: {}", user);
        return service.registerUser(user);
    }

}
