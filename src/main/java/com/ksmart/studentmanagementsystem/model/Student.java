package com.ksmart.studentmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    @Table(name="student")
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String studentCode;
        private String name;
        private Integer age;
        private String course;
        private String email;
    }


