package com.avrezzon.mealplanningcalendar.config;

import com.avrezzon.mealplanningcalendar.converter.UserRegistrationConverter;
import com.avrezzon.mealplanningcalendar.converter.UserToDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserToDtoConverter());
        registry.addConverter(new UserRegistrationConverter());
    }
}
