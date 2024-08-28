package com.student_database.manage.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
@Getter
public class StudentConfig {
    @Value("${header.action}")
    private List<String> headerAction;
}
