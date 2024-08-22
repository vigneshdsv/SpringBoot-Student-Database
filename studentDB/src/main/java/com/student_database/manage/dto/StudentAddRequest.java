package com.student_database.manage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class StudentAddRequest {

    @JsonProperty("staffId")
    @NotBlank(message = "Staff id not provided")
    private String staffId;

    @JsonProperty("studentAction")
    @Pattern(regexp = "^(\\s*|ADDNEW|DELETE)$",message = "Mandatory input provided is wrong")
    private String studentAction;

    @JsonProperty("studentDetails")
    @NotEmpty(message = "studentDetails id not provided")
    private List<StudentDetails> studentDetails;

}
