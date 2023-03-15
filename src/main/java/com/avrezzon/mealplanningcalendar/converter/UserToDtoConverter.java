package com.avrezzon.mealplanningcalendar.converter;

import com.avrezzon.mealplanningcalendar.dto.UserDto;
import com.avrezzon.mealplanningcalendar.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserToDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User source) {
        return UserDto.builder()
                .username(source.getUsername())
                .firstname(source.getFirstname())
                .lastname(source.getLastname())
                .email(source.getEmail())
                .mealProfile(source.getMealProfile())
                .build();
    }
}
