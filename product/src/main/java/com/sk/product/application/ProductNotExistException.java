package com.sk.product.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotExistException extends RuntimeException {

    public ProductNotExistException(String message) {
        super(message);
    }
}
