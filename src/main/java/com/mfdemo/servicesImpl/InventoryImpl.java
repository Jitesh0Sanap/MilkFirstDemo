package com.mfdemo.servicesImpl;

import com.mfdemo.Exception.InventoryNotFoundException;
import com.mfdemo.Exception.ProductNotFoundException;
import com.mfdemo.dto.InventoryDto;
import com.mfdemo.entitie.Inventory;
import com.mfdemo.entitie.Product;
import com.mfdemo.repository.InventoryRepo;
import com.mfdemo.repository.ProductRepo;
import com.mfdemo.services.InventoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryImpl implements InventoryServices {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Product product = productRepo.findById(inventoryDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        inventory.setLastUpdated(LocalDateTime.now());
        inventory.setProductId(product);
        inventoryRepo.save(inventory);
        return modelMapper.map(inventory , InventoryDto.class);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<Inventory> listOfInventory = inventoryRepo.findAll();
        List<InventoryDto> collect = listOfInventory.stream().map(inventory -> modelMapper.map(inventory , InventoryDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto, long id) {
        Inventory inventory1 = inventoryRepo.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory not found with id: " + id));


        inventory1.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventory1.setLastUpdated(LocalDateTime.now());

        Product product = productRepo.findById(inventoryDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        inventory1.setProductId(product);

        inventoryRepo.save(inventory1);
        return modelMapper.map(inventory1, InventoryDto.class);
    }
}
