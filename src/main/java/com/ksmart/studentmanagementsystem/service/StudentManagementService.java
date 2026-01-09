package com.ksmart.studentmanagementsystem.service;

import com.ksmart.studentmanagementsystem.contract.StudentRequestDTO;
import com.ksmart.studentmanagementsystem.contract.StudentResponseDTO;
import com.ksmart.studentmanagementsystem.exception.MailIdDuplicationException;
import com.ksmart.studentmanagementsystem.exception.StudentCodeNotFoundException;

import com.ksmart.studentmanagementsystem.model.Student;
import com.ksmart.studentmanagementsystem.repository.StudentManagementRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentManagementService {


        private final StudentManagementRepository studentManagementRepository;
        private final ModelMapper modelMapper;

    public StudentResponseDTO addStudent(StudentRequestDTO studDto) {
        if(studentManagementRepository.existsByEmail(studDto.getEmail())){
            throw new MailIdDuplicationException(studDto.getEmail());

        }

        Student stud = modelMapper.map(studDto, Student.class);
        studentManagementRepository.save(stud);
        return modelMapper.map(stud, StudentResponseDTO.class);
    }

        public List<StudentResponseDTO> getAllStudents() {
            return studentManagementRepository.findAll()
                    .stream()
                    .map(stud -> modelMapper.map(stud, StudentResponseDTO.class))
                    .toList();
        }



        public StudentRequestDTO getStudentCode(String code) {

            Student stud = studentManagementRepository.findByStudentCode(code);
            if(stud==null) {

            throw new StudentCodeNotFoundException(code);
            }
                 return modelMapper.map(stud, StudentRequestDTO.class);

    }

    public String updateStudent(StudentRequestDTO studDto, String code) {
        Student stud =  studentManagementRepository.findByStudentCode(code);
        if(stud==null) {

            throw new StudentCodeNotFoundException(code);
        }
        modelMapper.map(studDto, stud);
        studentManagementRepository.save(stud);
        return " Student details updated : " ;

    }


    public StudentResponseDTO getStudentByCode(String code) {
        Student stud =  studentManagementRepository.findByStudentCode(code);
        if(stud==null) {

            throw new StudentCodeNotFoundException(code);
        }
        else {
            return modelMapper.map(stud, StudentResponseDTO.class);
        }

    }

    public void deleteStudent(String  code) {

        studentManagementRepository.delete(studentManagementRepository.findByStudentCode(code));


    }

}
