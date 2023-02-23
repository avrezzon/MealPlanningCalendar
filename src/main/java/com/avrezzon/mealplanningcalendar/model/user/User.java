package com.avrezzon.mealplanningcalendar.model.user;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.service.MealPlanFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document("User")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private CaloricIntake mealPlanType;
    private MealPlan template;
    private List<MealPlan> plan; //Plan out 7 days?

    public User(String username, String firstName, String lastName, String email, CaloricIntake intake){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mealPlanType = (intake != null) ? intake : CaloricIntake.CALORIES_2000;
        this.template = MealPlanFactory.getMealPlan(this.mealPlanType);
    }

    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mealPlanType = CaloricIntake.CALORIES_2000;
        this.template = MealPlanFactory.getMealPlan(CaloricIntake.CALORIES_2000);
    }

}
