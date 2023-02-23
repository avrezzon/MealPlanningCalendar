package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Vegetable extends Food {

    public static final Vegetable NO_OP = new Vegetable();

    public Vegetable() {
        super("VEGETABLE");
    }

    public Vegetable(String name, Double servingSize, Measurement measurement) {
        super(name, servingSize, measurement, "VEGETABLE");
    }
}
