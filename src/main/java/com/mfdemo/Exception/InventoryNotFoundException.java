package com.mfdemo.Exception;

public class InventoryNotFoundException extends RuntimeException{

    public InventoryNotFoundException(String message) {
        super(message);
    }
}
