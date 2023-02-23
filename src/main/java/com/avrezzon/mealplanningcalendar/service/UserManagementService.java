package com.avrezzon.mealplanningcalendar.service;

import com.avrezzon.mealplanningcalendar.dto.UserDto;
import com.avrezzon.mealplanningcalendar.exception.ResourceNotFoundException;
import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<UserDto> getRegisteredUsers() {
        return repository.findAll()
                .stream().map(user -> new UserDto(user.getUsername(), user.getFirstName(), user.getLastName(),
                        user.getEmail(), user.getMealPlanType()))
                .toList();
    }

    public User getUser(String username){
        return repository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));
    }

    public User updateUserMealPlan(String username, CaloricIntake intake) {
        Optional<User> potentialUser = repository.findById(username);
        return potentialUser.map(user -> {
                    user.setTemplate(MealPlanFactory.getMealPlan(intake));
                    log.info("Updating the user's caloric intake to: {}", intake.toString());
                    return repository.save(user);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteUser(String username) {

        Optional<User> potentialUser = repository.findById(username);
        if (!potentialUser.isPresent())
            throw new ResourceNotFoundException();

        log.info("Deleting user {}...", username);

        repository.deleteById(username);
    }

}
