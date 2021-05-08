package com.crio.xmeme.advice;

import com.crio.xmeme.exceptions.MemeAlreadyExists;
import com.crio.xmeme.exceptions.MemeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(MemeAlreadyExists.class)
    public ResponseEntity<String> HandleMemeException(MemeAlreadyExists memeAlreadyExists){
        return new ResponseEntity<String>("Meme already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MemeNotFoundException.class)
    public  ResponseEntity<String>  MemeNotFoundHandler(MemeNotFoundException memeNotFoundException){
        return  new ResponseEntity<String>("Meme not found", HttpStatus.NOT_FOUND);
    }
}
