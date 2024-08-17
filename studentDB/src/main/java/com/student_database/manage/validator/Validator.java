package com.student_database.manage.validator;

import com.student_database.manage.dto.Constants;
import com.student_database.manage.dto.StudentEntityRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class Validator {

    public void validateRequest(StudentEntityRequest request, HttpHeaders headders){
            validateHeadders(headders);
            if(!ObjectUtils.isEmpty(request)){
                    validateInputRequest(request);
            }
            else{
                throw  new IllegalArgumentException(Constants.REQUEST_MISSING);
            }
    }

    private void validateHeadders(HttpHeaders headders) {

    }

    private void validateInputRequest(StudentEntityRequest request) {
    }

}