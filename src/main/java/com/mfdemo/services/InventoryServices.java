package com.mfdemo.services;

import com.mfdemo.dto.InventoryDto;
import com.mfdemo.entitie.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryServices {

    public InventoryDto createInventory(InventoryDto inventoryDto);
    public List<InventoryDto> getAllInventory();
    public InventoryDto updateInventory(InventoryDto inventoryDto , long id);
}
