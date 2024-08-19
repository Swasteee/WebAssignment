package com.example.furniturerental.backend.Service.impl;

import com.example.furniturerental.backend.Entity.FurnitureRentEntity;
import com.example.furniturerental.backend.Pojo.FurnitureRentPojo;
import com.example.furniturerental.backend.Repository.FurnitureRentalRepository;
import com.example.furniturerental.backend.Service.FurnitureRentingService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FurnitureRentServieImpl implements FurnitureRentingService {
    @Override
    public void saveFurnitureRental(FurnitureRentPojo bikeRentalPojo) throws IOException {

    }

    @Override
    public void updateFurniture(FurnitureRentPojo bikeRentalPojo) throws IOException {

    }

    @Override
    public List<FurnitureRentEntity> getAllFurnitureRentals() {
        return List.of();
    }

    @Override
    public Optional<FurnitureRentEntity> getFurnitureRentalById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deletefurnitureRental(Integer id) {
        FurnitureRentalRepository.deletebyId();
    }


}
