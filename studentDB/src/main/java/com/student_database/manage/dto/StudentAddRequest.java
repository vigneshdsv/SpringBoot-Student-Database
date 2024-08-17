package com.student_database.manage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class StudentAddRequest {

    @JsonProperty("staffId")
    @NotEmpty(message = "Satff id not provided")
    private String staffId;

    @Pattern(regexp = "^(\\s*|ADDNEW|DELETE)$",
            message = "Madatory input is wrong or not provided")
    private String studentAction;

    @JsonProperty("staffId")
    @NotEmpty(message = "studentDetails id not provided")
    private List<StudentDetails> studentDetails;

}
