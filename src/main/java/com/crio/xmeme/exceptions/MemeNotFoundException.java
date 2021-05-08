package com.crio.xmeme.exceptions;

import org.springframework.http.HttpStatus;

public class MemeNotFoundException extends  RuntimeException {
    private HttpStatus status;
    private String message;


    public MemeNotFoundException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;

    }


}
