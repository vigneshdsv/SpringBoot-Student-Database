package com.student_database.manage.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentException extends RuntimeException {

    private  String errorCode;
    private String errorMessage;
}
