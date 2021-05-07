package com.crio.xmeme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT , reason = "Some parameters are invalid")
public class MemeException extends  RuntimeException {

    private HttpStatus status;
    private String message;
    private String errors;

    public MemeException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
//        this.errors = errors;
    }

//    public MemeException(HttpStatus status, String message, String error) {
//        super();
//        this.status = status;
//        this.message = message;
//        errors = Arrays.asList(error);
//    }

}
