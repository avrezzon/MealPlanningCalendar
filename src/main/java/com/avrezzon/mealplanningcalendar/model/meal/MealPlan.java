package com.avrezzon.mealplanningcalendar.model.meal;

import com.avrezzon.mealplanningcalendar.model.Serving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {
    private Map<MealType, List<Serving>> layout;
}
