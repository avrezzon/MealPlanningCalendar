package com.avrezzon.mealplanningcalendar.model;

import com.avrezzon.mealplanningcalendar.model.meal.MealPlan;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
//TODO fix the USER dto to include this field

@Data
public class Profile implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private CaloricIntake mealPlanType;
    private MealPlan template;
    private List<MealPlan> plan; //Plan out 7 days?
}
