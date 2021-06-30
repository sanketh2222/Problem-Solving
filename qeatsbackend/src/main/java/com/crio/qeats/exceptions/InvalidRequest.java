package com.crio.qeats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Some parameters are invalid")
public class InvalidRequest extends RuntimeException {

    private HttpStatus status;
    private String message;
    private String errors;

    public InvalidRequest(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public InvalidRequest(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
    
}