package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Carbohydrate extends Food {

    public static final Carbohydrate NO_OP = new Carbohydrate();
    public Carbohydrate(String name, Double servingSize, Measurement measurement) {
        super(name, servingSize, measurement, "PROTEIN");
    }

    ;
}
