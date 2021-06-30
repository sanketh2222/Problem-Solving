package com.crio.qeats.advise;

import com.crio.qeats.exceptions.InvalidRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(InvalidRequest.class)
    public ResponseEntity<String> HandleMemeException(InvalidRequest invalidRequest){
        return new ResponseEntity<String>("Incorrect request",HttpStatus.BAD_REQUEST);
    }
    
}