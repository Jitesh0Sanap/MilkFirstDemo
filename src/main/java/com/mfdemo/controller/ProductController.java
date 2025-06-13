package com.mfdemo.controller;

import com.mfdemo.Exception.ApiResponce;
import com.mfdemo.dto.ProductDto;
import com.mfdemo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
        ProductDto productDto1 = productService.addProduct(productDto);
        return new ResponseEntity<>(productDto1 , HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtos = productService.getAll();
        return new ResponseEntity<>(productDtos , HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable long id){
        ProductDto productDto = productService.getById(id);
        return new ResponseEntity<>(productDto , HttpStatus.FOUND);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto , @PathVariable Long id){
        ProductDto update = productService.update(productDto, id);
        return new ResponseEntity<>(update , HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ApiResponce> deleteById(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity<ApiResponce>(new ApiResponce("Product Delete Successfully" , true),HttpStatus.OK);
    }
}
