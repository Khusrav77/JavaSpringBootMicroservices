package com.shh.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException {

    public ResourceNotFoundExceptions(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with thr given input data %s %s", resourceName, fieldName, fieldValue));
    }
}
