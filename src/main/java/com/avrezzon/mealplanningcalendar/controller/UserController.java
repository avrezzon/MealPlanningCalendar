package com.avrezzon.mealplanningcalendar.controller;

import com.avrezzon.mealplanningcalendar.dto.UserDto;
import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserManagementService service;

    @GetMapping
    public List<UserDto> getAllRegisteredUsers() {
        log.info("Retreiving all of the registered users");
        return service.getRegisteredUsers();
    }

    @GetMapping("/{username}")
    public User findUser(@PathVariable String username) {
        log.info("Searching for user with username of {}", username);
        return service.getUser(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserDto user) {
        log.info("Received request to register user: {}", user);
        return service.registerUser(user);
    }

    @PutMapping("/{username}")
    public User updateUserCalories(@PathVariable String username, @RequestParam CaloricIntake caloricIntake) {
        log.info("Updating the user's meal plan template");
        return service.updateUserMealPlan(username, caloricIntake);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String username) {
        log.info("Attempting to remove user: {}", username);
        service.deleteUser(username);
    }

}
