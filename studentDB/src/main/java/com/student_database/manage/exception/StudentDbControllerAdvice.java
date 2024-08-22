package com.student_database.manage.exception;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentDbControllerAdvice {
    @SneakyThrows
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorItem> handleStudentException(StudentException ex){
        ErrorItem res = ErrorItem.builder().errorCode(ex.getErrorCode()).message(ex.getErrorMessage()).build();

        return new ResponseEntity<>(res, HttpStatusCode.valueOf(400));

    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(StudentException.class)
//    public ErrorItem handleStudentException(StudentException ex){
//        ErrorItem res = ErrorItem.builder().errorCode(ex.getErrorCode()).message(ex.getErrorMessage()).build();
//
//        return res;
//
//    }

}
