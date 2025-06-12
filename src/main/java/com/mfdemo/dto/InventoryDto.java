package com.mfdemo.dto;

import com.mfdemo.entitie.Product;

import java.time.LocalDateTime;


public class InventoryDto {

    private long id;
    private long availableQuantity;
    private LocalDateTime lastUpdated;
    private long productId;

    public InventoryDto() {
    }

    public InventoryDto(long id, long availableQuantity, LocalDateTime lastUpdated, long productId) {
        this.id = id;
        this.availableQuantity = availableQuantity;
        this.lastUpdated = lastUpdated;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
