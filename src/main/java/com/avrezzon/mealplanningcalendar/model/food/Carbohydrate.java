package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;

@Data
public class Carbohydrate extends Food {
    public Carbohydrate(String name, Double servingSize, Measurement measurement) {
        super(name, servingSize, measurement, "PROTEIN");
    }

    ;
}
