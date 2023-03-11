package com.avrezzon.mealplanningcalendar.model;

import com.avrezzon.mealplanningcalendar.model.meal.MealPlan;
import com.avrezzon.mealplanningcalendar.service.MealPlanFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@Document("User")
public class User implements UserDetails {

    @MongoId
    private ObjectId id;
    public String username;
    private String password;
    private Set<UserRole> userRoles;

    //FIXME
    //TODO create a mapper to the user dto
//    private Profile profile;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getUserRoles();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
