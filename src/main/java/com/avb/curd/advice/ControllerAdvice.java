package com.avb.curd.advice;

import com.avb.curd.model.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> handleException(Exception exception){
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setData(null);
        response.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
