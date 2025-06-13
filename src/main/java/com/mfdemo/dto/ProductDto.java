package com.mfdemo.dto;

import com.mfdemo.entitie.Inventory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProductDto {

    private long id;

    @NotBlank(message = "Product name must not be blank")
    @Size(min=4 , message ="Username must be min of 4 character" )
    private String name;

    @NotBlank(message = "description must not be blank")
    @Size(min = 5, max = 200, message = "Description must be between 10 and 500 characters")
    private String description;

    @Positive(message = "Price must be greater than zero")
    private double price;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @NotBlank(message = "Unit must not be blank")
    private String unit;

    private Inventory inventory;

    public ProductDto() {
    }

    public ProductDto(String name, String description, double price, String category, String unit) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice( double price) {
        this.price = price;
    }

    public @NotBlank String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank String category) {
        this.category = category;
    }

    public @NotBlank String getUnit() {
        return unit;
    }

    public void setUnit(@NotBlank String unit) {
        this.unit = unit;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
