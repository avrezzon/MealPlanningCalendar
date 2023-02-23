package com.avrezzon.mealplanningcalendar.repository;

import com.avrezzon.mealplanningcalendar.model.food.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, String> {
}
