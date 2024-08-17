package com.student_database.manage.controller;

import com.student_database.manage.dto.Constants;
import com.student_database.manage.dto.CreateStudentResponse;
import com.student_database.manage.dto.StudentAddRequest;
import com.student_database.manage.dto.StudentDetails;
import com.student_database.manage.service.StudentService;
import com.student_database.manage.validator.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Iterator;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/student-db-management")
@Slf4j
public class StudentDBController {

    @Autowired
    StudentService service;

    @Autowired
    Validator validator;

    @PostMapping("/addNewStudent")
    public ResponseEntity<CreateStudentResponse> addNewStudent(
            @RequestBody StudentAddRequest request,
            @RequestHeader(value = Constants.CORRELATION_ID) String correlationId,
            @RequestHeader(value = Constants.ACTION) String action,
            @RequestHeader(value = Constants.TOKEN) String token,
            final WebRequest webRequest
            ){
        final HttpHeaders httpHeaders = requestHeadders(webRequest);
        log.info("Http headders received for the request ==>  {}",httpHeaders);
        log.info("Student request object received : {}", request);
        validator.validateRequest(request,httpHeaders);
        var response= service.studentAddService(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private static HttpHeaders requestHeadders(WebRequest webRequest) {

        final  HttpHeaders httpHeaders = new HttpHeaders();
        final Iterator<String> itr = webRequest.getHeaderNames();
        Stream.generate(()->null).takeWhile(i->itr.hasNext())
                .map(e->itr.next()).forEach(name->httpHeaders.add(name,webRequest.getHeader(name)));
        return httpHeaders;
    }
}
