package com.avrezzon.mealplanningcalendar.service;

import com.avrezzon.mealplanningcalendar.model.CaloricIntake;
import com.avrezzon.mealplanningcalendar.model.meal.MealType;
import com.avrezzon.mealplanningcalendar.model.Serving;
import com.avrezzon.mealplanningcalendar.model.food.Carbohydrate;
import com.avrezzon.mealplanningcalendar.model.food.Fruit;
import com.avrezzon.mealplanningcalendar.model.food.Protein;
import com.avrezzon.mealplanningcalendar.model.food.Vegetable;
import com.avrezzon.mealplanningcalendar.model.meal.MealPlan;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MealPlanFactory {

    public static MealPlan getMealPlan(CaloricIntake intakeLevel) {

        switch (intakeLevel) {
            case CALORIES_1200 -> {
                return make1200CalorieMealPlan();
            }
            case CALORIES_1500 -> {
                return make1500CalorieMealPlan();
            }
            case CALORIES_1800 -> {
                return make1800CalorieMealPlan();
            }
            case CALORIES_2000 -> {
                return make2000CalorieMealPlan();
            }
            default -> {
                log.error("Not really sure how we got here but lets cause a problem");
                throw new IllegalStateException("Invalid Caloric intake level selected for meal plan generation");
            }
        }
    }

    private static MealPlan make1200CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, Fruit.NO_OP),
                new Serving(.5, Carbohydrate.NO_OP),
                new Serving(.5, Protein.NO_OP)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(1.0, Vegetable.NO_OP),
                new Serving(1.0, Protein.NO_OP)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, Vegetable.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(1.0, Protein.NO_OP)));

        return new MealPlan(mealPlan);
    }

    private static MealPlan make1500CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, Fruit.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(.75, Protein.NO_OP)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(1.0, Vegetable.NO_OP),
                new Serving(1.0, Protein.NO_OP),
                new Serving(.5, Carbohydrate.NO_OP)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, Vegetable.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(2.0, Protein.NO_OP)));

        return new MealPlan(mealPlan);
    }
    private static MealPlan make1800CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, Fruit.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(1.0, Protein.NO_OP)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(2.0, Vegetable.NO_OP),
                new Serving(1.5, Protein.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, Vegetable.NO_OP),
                new Serving(1.5, Carbohydrate.NO_OP),
                new Serving(2.0, Protein.NO_OP)));

        return new MealPlan(mealPlan);
    }
    private static MealPlan make2000CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, Fruit.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(1.5, Protein.NO_OP)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(2.0, Vegetable.NO_OP),
                new Serving(2.0, Protein.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, Protein.NO_OP),
                new Serving(1.0, Fruit.NO_OP)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(3.0, Vegetable.NO_OP),
                new Serving(1.0, Carbohydrate.NO_OP),
                new Serving(2.0, Protein.NO_OP)));
        mealPlan.put(MealType.EVENING_SNACK, List.of(new Serving(1.0, Fruit.NO_OP)));

        return new MealPlan(mealPlan);
    }

}
