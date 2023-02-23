package com.avrezzon.mealplanningcalendar.service;

import com.avrezzon.mealplanningcalendar.dto.UserDto;
import com.avrezzon.mealplanningcalendar.model.user.User;
import com.avrezzon.mealplanningcalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository repository;

    public User registerUser(UserDto user) {

        Optional<User> potentialUser = repository.findById(user.getUsername());
        if (potentialUser.isPresent())
            throw new IllegalStateException("Username already is registered");

        potentialUser = repository.findByEmail(user.getEmail());
        if (potentialUser.isPresent())
            throw new IllegalStateException("Email is already associated with a user");

        User userRecord = new User(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getIntake());

        log.info("Creating new user {}", userRecord.getUsername());

        return repository.save(userRecord);
    }

}
