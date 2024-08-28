package com.student_database.manage.exception;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentException extends RuntimeException {

    private  String errorCode;
    private String errorMessage;
    private List<ErrorItem> errors;

    public StudentException(String errorCode, String errorMessage ){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public StudentException(String errorCode, List<ErrorItem> errors ){
        this.errorCode=errorCode;
        this.errors=errors;
    }
}
