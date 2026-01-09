package com.ksmart.studentmanagementsystem.exception;

public class MailIdDuplicationException extends RuntimeException {

    public MailIdDuplicationException(String email){
        super("Mail id already Exists " + email);
    }

}
