package com.restful.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Damiano Alves on 22/02/19
 * damiano.alves@gmail.com
 */
public class CustomException extends ResponseStatusException {

    private String errorMessage;
    private HttpStatus status;

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public CustomException(String errorMessage, HttpStatus status) {
        super(status);
        this.errorMessage = errorMessage;
        this.status = status;
    }
}