package com.restful.api.error;

import org.springframework.http.HttpStatus;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

public class ErrorResponse {

    private Integer code;
    private String message;

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
}