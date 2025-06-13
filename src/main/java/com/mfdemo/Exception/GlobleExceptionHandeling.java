package com.mfdemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> handelMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String , String> resp = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            resp.put(error.getField() , error.getDefaultMessage());
        });
        return new ResponseEntity<>(resp , HttpStatus.BAD_REQUEST);

    }
 }
