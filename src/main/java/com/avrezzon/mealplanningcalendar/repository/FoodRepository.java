package com.avrezzon.mealplanningcalendar.repository;

import com.avrezzon.mealplanningcalendar.model.food.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
