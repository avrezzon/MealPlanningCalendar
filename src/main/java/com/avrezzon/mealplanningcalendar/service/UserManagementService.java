package com.avrezzon.mealplanningcalendar.service;

import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.repository.UserRepository;
import com.avrezzon.mealplanningcalendar.util.SessionUtilities;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService implements UserDetailsService {

    private final UserRepository repository;
    private final ConversionService converter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(username);
        return user;
    }

    public User findUser(HttpSession session){
        UserDetails details = SessionUtilities.getCurrentUser(session);
        return findUser(details.getUsername());
    }

    public User findUser(String username){
        return Optional.ofNullable(repository.findUserByUsername(username))
                .orElseThrow(() -> new IllegalStateException("Cannot find registered username"));
    }
    public User registerNewUser(User user) {
        log.info("Attempting to create user: {}", user.getUsername());
        //TODO add steps to verify that the username or the email doesnt already exist
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
/*
    FIXME
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

//    public List<UserDto> getRegisteredUsers() {
//        return repository.findAll()
//                .stream().map(user -> new UserDto(user.getUsername(), user.getFirstName(), user.getLastName(),
//                        user.getEmail(), user.getMealPlanType()))
//                .toList();
//    }

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
    }*/



}
