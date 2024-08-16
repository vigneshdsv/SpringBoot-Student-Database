package StudentDatabase.studentDB.controller;

import StudentDatabase.studentDB.dto.Constants;
import StudentDatabase.studentDB.dto.CreateStudentResponse;
import StudentDatabase.studentDB.dto.StudentEntityRequest;
import StudentDatabase.studentDB.service.StudentService;
import StudentDatabase.studentDB.validator.Validator;
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
public class StudentDBController {

    @Autowired
    StudentService service;

    @Autowired
    Validator validator;

    @PostMapping("/addNewStudent")
    public ResponseEntity<CreateStudentResponse> addNewStudent(
            @RequestBody StudentEntityRequest request,
            @RequestHeader(value = Constants.CORRELATION_ID) String correlationId,
            @RequestHeader(value = Constants.ACTION) String action,
            @RequestHeader(value = Constants.TOKEN) String token,
            final WebRequest webRequest
            ){
        final HttpHeaders httpHeaders = requestHeadders(webRequest);
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
