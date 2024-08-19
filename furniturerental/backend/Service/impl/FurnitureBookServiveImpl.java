package com.example.furniturerental.backend.Service.impl;

import com.example.furniturerental.backend.Entity.FurnitureBookEntity;
import com.example.furniturerental.backend.Pojo.FurnitureBookingPojo;
import com.example.furniturerental.backend.Service.FurnitureBookingService;

import java.util.List;
import java.util.Optional;

public class FurnitureBookServiveImpl implements FurnitureBookingService {

    @Override
    public void saveBikeBooking(FurnitureBookingPojo furnitureBookingPojo) {

    }

    @Override
    public List<FurnitureBookEntity> getAllFurnitureBooking() {
        return List.of();
    }

    @Override
    public Optional<FurnitureBookEntity> getFurnitureBookingById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteFurnitureBooking(Integer id) {

    }
}
