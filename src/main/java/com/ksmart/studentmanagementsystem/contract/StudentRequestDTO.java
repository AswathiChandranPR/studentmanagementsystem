package com.ksmart.studentmanagementsystem.contract;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentRequestDTO {

    @NotBlank(message = "studentCode cannot be blank")
    private String studentCode;
    @NotBlank(message = "name cannot be blank")
    private String name;
    private Integer age;
    private String course;
    @Email
    private String email;
}

