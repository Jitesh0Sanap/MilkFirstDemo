package com.mfdemo.controller;

import com.mfdemo.dto.InventoryDto;
import com.mfdemo.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryServices inventoryServices;

    @PostMapping("/inventory")
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto){
        InventoryDto inventory = inventoryServices.createInventory(inventoryDto);
        return new ResponseEntity<>(inventory , HttpStatus.CREATED);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryDto>> getAllInventory(){
        List<InventoryDto> allInventory = inventoryServices.getAllInventory();
        return new ResponseEntity<>(allInventory , HttpStatus.OK);
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity<InventoryDto> updataInventory(@RequestBody InventoryDto inventoryDto , @PathVariable long id){
        InventoryDto updatedInventory = inventoryServices.updateInventory(inventoryDto, id);
        return new ResponseEntity<>(updatedInventory , HttpStatus.OK);
    }
}
