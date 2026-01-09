package com.ksmart.studentmanagementsystem.contract;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentResponseDTO {

    private UUID id;
    private String studentCode;
   private String name;
    private Integer age;
    private String course;
    private String email;
}

