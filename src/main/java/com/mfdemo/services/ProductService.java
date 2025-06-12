package com.mfdemo.services;

import com.mfdemo.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    public ProductDto addProduct(ProductDto productDto);
    public List<ProductDto> getAll();
    public ProductDto getById(long id);
    public ProductDto update(ProductDto productDto , long id);
    public void delete(long id);
}
