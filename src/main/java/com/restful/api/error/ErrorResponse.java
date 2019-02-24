package com.restful.api.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

public class ErrorResponse {

    private Integer code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ObjectError> details;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ObjectError> getDetails() {
        return details;
    }

    public void setDetails(List<ObjectError> details) {
        this.details = details;
    }
}