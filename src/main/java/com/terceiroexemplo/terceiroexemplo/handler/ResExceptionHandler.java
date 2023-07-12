package com.terceiroexemplo.terceiroexemplo.handler;

import com.terceiroexemplo.terceiroexemplo.model.error.ErrorMessage;
import com.terceiroexemplo.terceiroexemplo.model.exception.ResourceConflict;
import com.terceiroexemplo.terceiroexemplo.model.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResExceptionHandler {

    @ExceptionHandler(ResourceConflict.class)
    public ResponseEntity<?> handleResourceConflictException(ResourceConflict ex) {
        ErrorMessage error = new ErrorMessage("Conflict", HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFound ex) {
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
