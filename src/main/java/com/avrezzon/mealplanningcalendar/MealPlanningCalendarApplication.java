package com.avrezzon.mealplanningcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

@SpringBootApplication
@EnableMongoHttpSession
public class MealPlanningCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealPlanningCalendarApplication.class, args);
    }

}