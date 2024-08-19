package com.example.furniturerental.backend.Service;

import com.example.furniturerental.backend.Entity.FurnitureRentEntity;
import com.example.furniturerental.backend.Pojo.FurnitureRentPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FurnitureRentingService {
    void saveFurnitureRental(FurnitureRentPojo bikeRentalPojo) throws IOException;
    void updateFurniture(FurnitureRentPojo bikeRentalPojo) throws IOException;
    List<FurnitureRentEntity> getAllFurnitureRentals();
    Optional<FurnitureRentEntity> getFurnitureRentalById(Integer id);
    void deletefurnitureRental(Integer id);


}

