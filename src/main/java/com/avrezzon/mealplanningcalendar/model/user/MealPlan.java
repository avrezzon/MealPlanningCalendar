package com.avrezzon.mealplanningcalendar.model.user;

import com.avrezzon.mealplanningcalendar.model.MealType;
import com.avrezzon.mealplanningcalendar.model.Serving;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MealPlan {
    private Map<MealType, List<Serving>> layout;
}
