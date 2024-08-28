package com.student_database.manage.validator;

import com.student_database.manage.config.StudentConfig;
import com.student_database.manage.dto.Constants;
import com.student_database.manage.dto.StudentAddRequest;
import com.student_database.manage.dto.StudentDetails;
import com.student_database.manage.exception.ErrorItem;
import com.student_database.manage.exception.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.student_database.manage.dto.Constants.*;

@Component
@Slf4j
public class Validator {

    @Autowired
    StudentConfig config;

    public void validateRequest(StudentAddRequest request, HttpHeaders headders){
            validateHeadders(headders);
            if(!CollectionUtils.isEmpty(request.getStudentDetails())){
                    validateInputRequest(request.getStudentDetails());
            }
            else{
                throw  new StudentException("Bad Request-400",Constants.REQUEST_MISSING);
            }
    }

    private void validateHeadders(HttpHeaders headders) {
        List<String> missingHeaders = new ArrayList<>();
        List<String> invalidHeaders = new ArrayList<>();

        log.info("expected header action : {}", config.getHeaderAction());

        if (ObjectUtils.isEmpty(headders.get(CORRELATION_ID).get(0)) )
            missingHeaders.add(CORRELATION_ID);

        if (ObjectUtils.isEmpty(headders.get(ACTION).get(0))){
            missingHeaders.add(ACTION);

        }
        if(!config.getHeaderAction().contains(ObjectUtils.isEmpty(headders.get(ACTION).get(0)))){
            invalidHeaders.add(ACTION +"-"+ headders.get(ACTION));
        }

        if (ObjectUtils.isEmpty(headders.get(TOKEN).get(0)))
            missingHeaders.add(TOKEN);

        if (!CollectionUtils.isEmpty(missingHeaders) || !CollectionUtils.isEmpty(invalidHeaders) ){
            log.info("headers validation failed {}", missingHeaders);
            List<ErrorItem> errors = getErrorItems(missingHeaders, invalidHeaders);

            throw  new StudentException("Bad Request-400",errors);
        }
    }

    private static List<ErrorItem> getErrorItems(List<String> missingHeaders, List<String> invalidHeaders) {
        List<ErrorItem> errors = new ArrayList<>();
        if (!CollectionUtils.isEmpty(missingHeaders)) {
            ErrorItem errorItemMissing = new ErrorItem("400", "Header data " + missingHeaders + " is missing");
            errors.add(errorItemMissing);
        }
        if (!CollectionUtils.isEmpty(invalidHeaders)) {
            ErrorItem errorItemInvalid = new ErrorItem("400", "Header data " + invalidHeaders + " is invalid");
            errors.add(errorItemInvalid);
        }
        return errors;
    }

    private void validateInputRequest(List<StudentDetails> studentDetailsList) {

    }

}
