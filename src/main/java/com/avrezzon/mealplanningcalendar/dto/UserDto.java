package com.avrezzon.mealplanningcalendar.dto;

import com.avrezzon.mealplanningcalendar.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String firstName;
    private Profile userProfile;
}
