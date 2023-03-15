package com.avrezzon.mealplanningcalendar.model.meal;

import com.avrezzon.mealplanningcalendar.model.food.Food;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Serving implements Serializable {
    private Double servingQty;
    private Food food;
}
