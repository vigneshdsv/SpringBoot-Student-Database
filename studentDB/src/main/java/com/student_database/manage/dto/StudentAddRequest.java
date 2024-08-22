package com.student_database.manage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Validated
public class StudentAddRequest {

    @JsonProperty("staffId")
    @NotBlank(message = "Staff id not provided")
    private String staffId;

    @JsonProperty("studentAction")
    @Pattern(regexp = "^(\\s*|ADDNEW|DELETE)$",message = "input provided for studentAction is wrong")
    private String studentAction;

    @JsonProperty("studentDetails")
    @NotEmpty(message = "Mandatory input studentDetails not provided")
    private List<StudentDetails> studentDetails;

}
