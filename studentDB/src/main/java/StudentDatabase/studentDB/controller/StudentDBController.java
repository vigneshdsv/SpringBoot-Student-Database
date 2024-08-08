package StudentDatabase.studentDB.controller;

import StudentDatabase.studentDB.dto.CreateStudentResponse;
import StudentDatabase.studentDB.dto.StudentEntityRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student-db-management")
public class StudentDBController {
    @PostMapping("/addNewStudent")
    public ResponseEntity<CreateStudentResponse> addNewStudent(
            @RequestBody StudentEntityRequest request,
            @RequestHeader String correlationId,
            @RequestHeader String action,
            @RequestHeader String token
    ){

        var response= new CreateStudentResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
