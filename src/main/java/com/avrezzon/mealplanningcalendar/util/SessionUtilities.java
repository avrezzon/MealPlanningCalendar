package com.avrezzon.mealplanningcalendar.util;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
public class SessionUtilities {

    //TODO need to look into how to use the context more effectively, not sure that the entire User should be in the SecurityContext
    //  probably just the critical information
    public static UserDetails getCurrentUser(HttpSession session){
        SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        return (UserDetails) context.getAuthentication().getPrincipal();
    }


}
