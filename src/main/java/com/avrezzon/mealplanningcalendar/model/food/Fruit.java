package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Fruit extends Food {
    public Fruit(String name, Double servingSize, Measurement measurement){
        super(name, servingSize, measurement, "FRUIT");
    }
}
