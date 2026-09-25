package com.myapp.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> hadnleException(Exception e){
        return ResponseEntity.status(500).body("Something went wrong: " + e.getMessage());
    }
}
