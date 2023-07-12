package com.terceiroexemplo.terceiroexemplo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ResourceConflict extends RuntimeException {
    public ResourceConflict(String message) {
        super(message);
    }
}
