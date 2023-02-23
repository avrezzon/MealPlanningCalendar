package com.avrezzon.mealplanningcalendar.model.user;

import com.avrezzon.mealplanningcalendar.model.Serving;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Meal {
    private String name;

    //K: mfood type
    private Map<String, Serving> foodServing;
}
