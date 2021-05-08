package com.crio.xmeme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
@ResponseStatus(value = HttpStatus.CONFLICT , reason = "Some parameters are invalid")
public class MemeAlreadyExists extends RuntimeException {

    private HttpStatus status;
    private String message;
    private String errors;

    public MemeAlreadyExists(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public MemeAlreadyExists(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }



}
