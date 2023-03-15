package com.avrezzon.mealplanningcalendar.controller;

import com.avrezzon.mealplanningcalendar.dto.ProfileDto;
import com.avrezzon.mealplanningcalendar.model.User;
import com.avrezzon.mealplanningcalendar.util.SessionUtilities;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planner")
public class PlannerController {
    @PostMapping
    public ProfileDto generateSampleMealPlan(HttpSession session){
        User currentUser = SessionUtilities.getCurrentUser(session);

        return null;
    }
}
