package com.ksmart.studentmanagementsystem.controller;

import com.ksmart.studentmanagementsystem.contract.Response;
import com.ksmart.studentmanagementsystem.contract.StudentRequestDTO;
import com.ksmart.studentmanagementsystem.contract.StudentResponseDTO;
import com.ksmart.studentmanagementsystem.service.StudentManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentManagementController {

    private final StudentManagementService studentManagementService;

    @PostMapping("/api/student/")
    public ResponseEntity<Response<StudentResponseDTO>> addStudent(@Valid @RequestBody StudentRequestDTO studDto) {
        StudentResponseDTO stud = studentManagementService.addStudent(studDto);
        return ResponseEntity.ok(Response.<StudentResponseDTO>builder().payload(stud).message("Students Lists are : ").status("Y").build());
    }

    @GetMapping("list/students")
    public ResponseEntity<Response<List<StudentResponseDTO>>> getAllStudents() {
        List<StudentResponseDTO> studentList = studentManagementService.getAllStudents();
        if (studentList.isEmpty()) {
            return ResponseEntity.ok(Response.<List<StudentResponseDTO>>builder().message("Not found any Student  : ").status("N").build());

        }
        return ResponseEntity.ok(Response.<List<StudentResponseDTO>>builder().payload(studentList).message("Added Students are : ").status("Y").build());
    }

    @PutMapping("/api/student/{studentCode}")
    public String updateStudent(@Valid @RequestBody StudentRequestDTO studDto, @PathVariable String studentCode) {

        return studentManagementService.updateStudent(studDto, studentCode);
    }


    @GetMapping("api/students/{code}")
    public ResponseEntity<Response<StudentResponseDTO>> getStudentByCode(@PathVariable String code) {
        StudentResponseDTO student = studentManagementService.getStudentByCode(code);
        return ResponseEntity.ok(Response.<StudentResponseDTO>builder().payload(student).message("Student List is : ").status("Y").build());
    }

    @DeleteMapping("/api/students/{studentCode}")
    public String deleteStudent(@PathVariable String studentCode) {
        studentManagementService.deleteStudent(studentCode);
        return " Student with code " + studentCode + " deleted : ";
    }
}