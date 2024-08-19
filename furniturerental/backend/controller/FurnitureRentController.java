package com.example.furniturerental.backend.controller;

import com.example.furniturerental.backend.Entity.FurnitureRentEntity;
import com.example.furniturerental.backend.Pojo.FurnitureRentPojo;
import com.example.furniturerental.backend.Service.FurnitureRentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/furniture-rentals")
public class FurnitureRentController {

    private final FurnitureRentingService furnitureRentingService = null;

    @Autowired
    public FurnitureRentController(FurnitureRentingService FurnitureRentingService) {
    }

    @PostMapping
    public void saveFurnitureRental(@RequestBody FurnitureRentPojo furnitureRentPojo) throws IOException {
        FurnitureRentEntity furnitureRentEntity = new FurnitureRentEntity();
        furnitureRentEntity.setId(furnitureRentPojo.getId());
        furnitureRentEntity.setFurnitureBrand(furnitureRentPojo.getFurnitureBrand());
        furnitureRentEntity.setPrice(furnitureRentPojo.getPrice());
        furnitureRentingService.saveFurnitureRental(furnitureRentPojo);
    }

    @PutMapping("/{id}")
    public void updateFurniture(@PathVariable Integer id, @RequestBody FurnitureRentPojo furnitureRentPojo) throws IOException {
        // Assuming the update method would involve fetching the existing entity and updating fields
        Optional<FurnitureRentEntity> existingRental = furnitureRentingService.getFurnitureRentalById(id);
        if (existingRental.isPresent()) {
            FurnitureRentEntity furnitureRentEntity = existingRental.get();
            furnitureRentEntity.setFurnitureBrand(furnitureRentPojo.getFurnitureBrand());
            furnitureRentEntity.setPrice(furnitureRentPojo.getPrice());
            furnitureRentingService.updateFurniture(furnitureRentPojo);
        }
    }

    @GetMapping
    public List<FurnitureRentEntity> getAllFurnitureRentals() {
        return furnitureRentingService.getAllFurnitureRentals();
    }

    @GetMapping("/{id}")
    public Optional<FurnitureRentEntity> getFurnitureRentalById(@PathVariable Integer id) {
        return furnitureRentingService.getFurnitureRentalById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFurnitureRental(@PathVariable Integer id) {
        furnitureRentingService.deletefurnitureRental(id);
    }
}
