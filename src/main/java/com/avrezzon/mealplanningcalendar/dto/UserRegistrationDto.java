package com.avrezzon.mealplanningcalendar.dto;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserRegistrationDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
