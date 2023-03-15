package com.avrezzon.mealplanningcalendar.converter;

import com.avrezzon.mealplanningcalendar.dto.UserRegistrationDto;
import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.model.MealProfile;
import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.model.UserRole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
public class UserRegistrationConverter implements Converter<UserRegistrationDto, User> {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User convert(UserRegistrationDto source) {
        return User.builder()
                .userRoles(Set.of(new UserRole("ROLE_USER")))
                .username(source.getUsername())
                .password(passwordEncoder.encode(source.getPassword()))
                .email(source.getEmail())
                .firstname(source.getFirstname())
                .lastname(source.getLastname())
                .mealProfile(new MealProfile(CaloricIntake.CALORIES_2000)) //Default for new users
                .build();
    }
}
