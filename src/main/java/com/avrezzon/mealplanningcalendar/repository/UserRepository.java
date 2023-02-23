package com.avrezzon.mealplanningcalendar.repository;

import com.avrezzon.mealplanningcalendar.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}
