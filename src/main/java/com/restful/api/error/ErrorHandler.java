package com.restful.api.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Damiano Alves on 22/02/19
 * damiano.alves@gmail.com
 */
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity exceptionHandler(CustomException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(ex.getStatus().value());
        error.setMessage(ex.getErrorMessage());
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ResponseStatus(value="HttpStatus.NOT_FOUND",reason"This customer is not found in the system")
    @ExceptionHandler(CustomException.class)
    public ResponseEntity exceptionHandler(CustomException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(ex.getStatus().value());
        error.setMessage(ex.getErrorMessage());
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
