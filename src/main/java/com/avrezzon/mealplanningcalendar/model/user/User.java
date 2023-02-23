package com.avrezzon.mealplanningcalendar.model.user;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
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
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private CaloricIntake mealPlanType;

    private MealPlan template;
    private List<MealPlan> plan; //Plan out 7 days?
}
