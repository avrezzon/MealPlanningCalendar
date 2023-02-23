package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;

@Data
public class Protein extends Food{
    public Protein (String name, Double servingSize, Measurement measurement){
        super(name, servingSize, measurement, "PROTEIN");
    };
}
