package com.student_database.manage.service;

import com.student_database.manage.dto.AddedList;
import com.student_database.manage.dto.CreateStudentResponse;
import com.student_database.manage.dto.NotAddedList;
import com.student_database.manage.dto.StudentAddRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    public CreateStudentResponse studentAddService(StudentAddRequest request) {

        var res = CreateStudentResponse.builder().status("200")
                .addedList(List.of(new AddedList(request.getStudentDetails().get(0).getId(),request.getStudentDetails().get(0).getName())))
                .notAddedListList(List.of(new NotAddedList(1003L,"Prabhkar"))).build();
        return res;
    }
}

