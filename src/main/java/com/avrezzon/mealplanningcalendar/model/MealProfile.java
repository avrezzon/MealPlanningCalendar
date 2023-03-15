package com.avrezzon.mealplanningcalendar.model;

import com.avrezzon.mealplanningcalendar.model.meal.MealPlan;
import com.avrezzon.mealplanningcalendar.service.MealPlanFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealProfile implements Serializable {

    private CaloricIntake mealPlanType;
    private MealPlan template;
    private List<MealPlan> plan; //Plan out 7 days?

    public MealProfile(CaloricIntake caloricIntake){
        this.mealPlanType = caloricIntake;
        this.plan = Collections.emptyList();
        this.template = MealPlanFactory.getMealPlan(caloricIntake);
    }
}
