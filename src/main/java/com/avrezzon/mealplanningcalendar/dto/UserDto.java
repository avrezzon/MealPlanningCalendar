package com.avrezzon.mealplanningcalendar.dto;

import com.avrezzon.mealplanningcalendar.model.MealProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private MealProfile mealProfile;
}
