package com.mfdemo.Exception;


public class ProductDeletionException extends RuntimeException{

    public ProductDeletionException(String message) {
        super(message);
    }
}
