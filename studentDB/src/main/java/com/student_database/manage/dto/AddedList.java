package com.student_database.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddedList {
    private Long id;
    private String name;
}
