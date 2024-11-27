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

import jakarta.validation.Valid;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.student_database.manage.dto.Constants.*;

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
            @RequestBody @Valid StudentAddRequest request,
            @RequestHeader(value = CORRELATION_ID) String correlationId,
            @RequestHeader(value = ACTION) String action,
            @RequestHeader(value = TOKEN) String token){
        final HttpHeaders httpHeaders = createHeadder(correlationId,action,token);
        log.info("Http headers received for the request ==>  {}",httpHeaders);
        //log.info("Student request object received : {}", request);
        validator.validateRequest(request,httpHeaders);
        var response= service.studentAddService(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private HttpHeaders createHeadder(String correlationId, String action, String token) {
        HttpHeaders req = new HttpHeaders();
        req.add(CORRELATION_ID,correlationId);
        req.add(ACTION,action);
        req.add(TOKEN,token);
        return req;
    }

    private static HttpHeaders requestHeadders(WebRequest webRequest) {

        final  HttpHeaders httpHeaders = new HttpHeaders();
        final Iterator<String> itr = webRequest.getHeaderNames();
        Stream.generate(()->null).takeWhile(i->itr.hasNext())
                .map(e->itr.next()).forEach(name->httpHeaders.add(name,webRequest.getHeader(name)));
        return httpHeaders;
    }
}
