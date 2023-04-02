package com.sk.product.application;

public class ProductExceedAmountException extends RuntimeException {

    public ProductExceedAmountException(String message) {
        super(message);
    }
}
