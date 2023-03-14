package com.avrezzon.mealplanningcalendar.controller;

import com.avrezzon.mealplanningcalendar.converter.UserRegistrationConverter;
import com.avrezzon.mealplanningcalendar.dto.UserRegistrationDto;
import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final ConversionService converter;
    private final UserManagementService service;


    @PostMapping("register")
    public User createUser(@RequestBody UserRegistrationDto dto) {
        log.info("Received request to create user: {}", dto.getUsername());
        log.debug("Attempting to convert the request");
        Optional<User> userToRegister = Optional.ofNullable(converter.convert(dto, User.class));
        return userToRegister.map(service::registerNewUser)
                .map(user -> {
                    log.info("Sucessfully registered new user: {}", user);
                    return user;
                })
                .orElseThrow(() -> new IllegalStateException(""));
    }

    @GetMapping
    public List<User> getAllRegisteredUsers(HttpSession session) {
        log.info("Retreiving all of the registered users");
//        session.getAttribute("PASSW")
        return service.getUsers();
    }
//
//    @GetMapping("/{username}")
//    public User findUser(@PathVariable String username) {
//        log.info("Searching for user with username of {}", username);
//        return service.getUser(username);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public User createUser(@RequestBody UserDto user) {
//        log.info("Received request to register user: {}", user);
//        return service.registerUser(user);
//    }
//
//    @PutMapping("/{username}")
//    public User updateUserCalories(@PathVariable String username, @RequestParam CaloricIntake caloricIntake) {
//        log.info("Updating the user's meal plan template");
//        return service.updateUserMealPlan(username, caloricIntake);
//    }
//
//    @DeleteMapping("/{username}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUser(@PathVariable String username) {
//        log.info("Attempting to remove user: {}", username);
//        service.deleteUser(username);
//    }

}
