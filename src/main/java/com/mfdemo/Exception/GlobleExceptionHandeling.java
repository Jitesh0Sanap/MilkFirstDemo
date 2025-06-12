package com.mfdemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandeling {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponce> handelResourceNotFoundException(ProductNotFoundException ex){

        String message  = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDeletionException.class)
    public ResponseEntity<ApiResponce> handelProductDeletionException(ProductDeletionException ex){

        String message  = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<ApiResponce> handelProductDeletionException(InventoryNotFoundException ex){

        String message  = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
    }
 }
