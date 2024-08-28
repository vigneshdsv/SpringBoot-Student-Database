package com.student_database.manage.dto;

import com.student_database.manage.exception.ErrorItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentExceptionResponse {

    private  String errorCode;
    private String errorMessage;
    private List<ErrorItem> errors;

    public StudentExceptionResponse(String errorCode, String errorMessage ){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public StudentExceptionResponse(String errorCode, List<ErrorItem> errors ){
        this.errorCode=errorCode;
        this.errors=errors;
    }
}
