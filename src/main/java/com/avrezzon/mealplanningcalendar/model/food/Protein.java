package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.Data;

@Data
public class Protein extends Food{

    public static final Protein NO_OP = new Protein();

    public Protein(){
        super("PROTEIN");
    }
    public Protein (String name, Double servingSize, Measurement measurement){
        super(name, servingSize, measurement, "PROTEIN");
    };
}
