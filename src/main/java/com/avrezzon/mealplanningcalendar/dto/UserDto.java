package com.avrezzon.mealplanningcalendar.dto;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private CaloricIntake mealPlanType;
}
