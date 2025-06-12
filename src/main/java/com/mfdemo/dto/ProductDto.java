package com.mfdemo.dto;

import com.mfdemo.entitie.Inventory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProductDto {

    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private double price;

    @NotBlank
    private String category;

    @NotBlank
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

    @NotBlank
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotBlank double price) {
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
