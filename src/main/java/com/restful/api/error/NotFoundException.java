package com.restful.api.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Damiano Alves on 22/02/19
 * damiano.alves@gmail.com
 */
public class NotFoundException extends ResponseStatusException {

    private String errorMessage;
    private HttpStatus status;

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public NotFoundException(String errorMessage) {
        super(HttpStatus.NOT_FOUND);
        this.errorMessage = errorMessage;
        this.status = HttpStatus.NOT_FOUND;
    }
}