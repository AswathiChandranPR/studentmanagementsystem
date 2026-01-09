package com.ksmart.studentmanagementsystem.exception;

public class StudentCodeNotFoundException extends RuntimeException{
    public StudentCodeNotFoundException(String code){
        super("Cannot find the student with code " + code);
    }


    }
