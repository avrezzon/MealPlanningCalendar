package com.avrezzon.mealplanningcalendar.model.meal;

import com.avrezzon.mealplanningcalendar.model.food.Food;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Serving {
    private Double servingQty;
    private Food food;
}
