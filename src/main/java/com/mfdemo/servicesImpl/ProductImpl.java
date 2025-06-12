package com.mfdemo.servicesImpl;

import com.mfdemo.Exception.ProductNotFoundException;
import com.mfdemo.dto.ProductDto;
import com.mfdemo.entitie.Product;
import com.mfdemo.repository.ProductRepo;
import com.mfdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;



    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = dtoToToProduct(productDto);
        productRepo.save(product);
        ProductDto newUser = this.productToDto(product);
        return newUser;
    }

    @Override
    public List<ProductDto> getAll() {

        List<Product> allProduct = productRepo.findAll();
        List<ProductDto> allProductDto = allProduct.stream().map(product -> this.productToDto(product)).collect(Collectors.toList());
        return allProductDto;
    }

    @Override
    public ProductDto getById(long id) {
        Product product = this.productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return this.productToDto(product);
    }

    @Override
    public ProductDto update(ProductDto productDto, long id) {
        Product product = this.productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Given Id is wrong for update a product : " +id));
        product.setName(productDto.getName());
        product.setUnit(productDto.getUnit());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        productRepo.save(product);
        return productToDto(product);
    }

    @Override
    public void delete(long id) {
        Product product = this.productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Given Id is wrong for delete a product"));
        productRepo.deleteById(id);

    }

    public Product dtoToToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setUnit(productDto.getUnit());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());

        return product;
    }
    public ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setUnit(product.getUnit());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        if (product.getInventory() != null) {
            productDto.setInventory(product.getInventory());
        }
        return productDto;
    }
}
