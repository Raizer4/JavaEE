package com.example.marketplace.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
