package com.mfdemo.repository;

import com.mfdemo.entitie.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory , Long> {
}
