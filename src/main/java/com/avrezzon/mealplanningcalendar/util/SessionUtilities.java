package com.avrezzon.mealplanningcalendar.util;

import com.avrezzon.mealplanningcalendar.model.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionUtilities {

    public static User getCurrentUser(HttpSession session){
        return (User) session.getAttribute("SPRING_SECURITY_CONTEXT");
    }


}
