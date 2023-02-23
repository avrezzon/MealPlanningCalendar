package com.avrezzon.mealplanningcalendar.model.food;

import com.avrezzon.mealplanningcalendar.model.Measurement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Fruit extends Food {

    public static final Fruit NO_OP = new Fruit();

    public Fruit(){
        super("FRUIT");
    }
    public Fruit(String name, Double servingSize, Measurement measurement){
        super(name, servingSize, measurement, "FRUIT");
    }
}
