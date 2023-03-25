package com.sk.product.application.port.out;

public class ProductNotExistException extends RuntimeException {

    public ProductNotExistException(String message) {
        super(message);
    }
}
