package com.restful.api.error;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Damiano Alves on 22/02/19
 * damiano.alves@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, NotFoundException.class, MalformedJwtException.class})
    public final ResponseEntity handleException(Exception ex ) {
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            headers.add("supportedMethods", String.valueOf(((HttpRequestMethodNotSupportedException) ex).getSupportedHttpMethods()));
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Método não permitido");
            errorResponse.setCode(405);
            return new ResponseEntity<>(errorResponse, headers,  HttpStatus.METHOD_NOT_ALLOWED);
        } else if (ex instanceof HttpMessageNotReadableException) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Erro no corpo da requisição");
            errorResponse.setCode(400);
            return new ResponseEntity<>(errorResponse, headers,  HttpStatus.BAD_REQUEST);
        } else if (ex instanceof MethodArgumentNotValidException) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Corpo da requisição não inválido");
            errorResponse.setCode(400);
            ((MethodArgumentNotValidException) ex).getBindingResult();
            errorResponse.setDetails(((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors());
            return new ResponseEntity<>(errorResponse, headers,  HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NotFoundException) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(((NotFoundException) ex).getErrorMessage());
            errorResponse.setCode(404);
            return new ResponseEntity<>(errorResponse, headers,  HttpStatus.NOT_FOUND);
        }else if (ex instanceof MalformedJwtException) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Token inválido");
            errorResponse.setCode(400);
            return new ResponseEntity<>(errorResponse, headers,  HttpStatus.BAD_REQUEST);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Erro interno do servidor");
            errorResponse.setCode(500);
            return new ResponseEntity<>(errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}