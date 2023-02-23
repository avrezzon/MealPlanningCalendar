package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;

@Data
public class Vegetable extends Food{
    public Vegetable (String name, Double servingSize, Measurement measurement){
        super(name, servingSize, measurement, "VEGETABLE");
    }
}
