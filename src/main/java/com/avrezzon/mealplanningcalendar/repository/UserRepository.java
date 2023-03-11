package com.avrezzon.mealplanningcalendar.repository;

import com.avrezzon.mealplanningcalendar.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @SuppressWarnings("SpringDataMongoDBJsonFieldInspection")
    @Query("{username:'?0'}")
    User findUserByUsername(String username);
//    Optional<User> findByEmail(String email);
}
