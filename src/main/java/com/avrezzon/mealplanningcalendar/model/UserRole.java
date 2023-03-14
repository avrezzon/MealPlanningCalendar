package com.avrezzon.mealplanningcalendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class UserRole implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
