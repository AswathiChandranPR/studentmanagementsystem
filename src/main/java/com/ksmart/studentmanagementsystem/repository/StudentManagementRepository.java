package com.ksmart.studentmanagementsystem.repository;


import com.ksmart.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentManagementRepository extends JpaRepository<Student, UUID> {

    Student findByStudentCode(String code);

    boolean existsByEmail(String email);
}
