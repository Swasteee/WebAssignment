package com.example.furniturerental.backend.Service;


import com.example.furniturerental.backend.Entity.FurnitureBookEntity;
import com.example.furniturerental.backend.Pojo.FurnitureBookingPojo;

import java.util.List;
import java.util.Optional;

public interface FurnitureBookingService {
    void saveBikeBooking(FurnitureBookingPojo furnitureBookingPojo);
    List<FurnitureBookEntity> getAllFurnitureBooking();
    Optional<FurnitureBookEntity> getFurnitureBookingById(Integer id);
    void deleteFurnitureBooking(Integer id);
}
