package com.avrezzon.mealplanningcalendar.model.user;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private CaloricIntake intake;

    private MealPlan template;
    private List<MealPlan> plan; //Plan out 7 days?

}
