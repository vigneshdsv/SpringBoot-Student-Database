package com.student_database.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CreateStudentResponse {
    private String status;
    private List<AddedList> addedList;
    private List<NotAddedList> notAddedListList;
}
