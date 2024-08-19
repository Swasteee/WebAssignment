package com.example.furniturerental.backend.controller;

import com.example.furniturerental.backend.Entity.FurnitureBookEntity;
import com.example.furniturerental.backend.Pojo.FurnitureBookingPojo;
import com.example.furniturerental.backend.Service.FurnitureBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/furniture")
    @RequiredArgsConstructor
    public class FurnitureBookingController {
        private final FurnitureBookingService furnitureBookingService;

        @PostMapping("/furniturebooking")
        public void bookFurniture(@RequestBody FurnitureBookingPojo furnitureBook) {
            furnitureBookingService.saveBikeBooking(furnitureBook);
        }

        @GetMapping("/rentals")
        public List<FurnitureBookEntity> getAllFurnitureBooking() {
            return furnitureBookingService.getAllFurnitureBooking();
        }

        @GetMapping("/rentals/{id}")
        public Optional<FurnitureBookEntity> getFurnitureBookingById(@PathVariable Integer id) {
            return furnitureBookingService.getFurnitureBookingById(id);
        }
        @DeleteMapping("/rentals/{id}")
        public void deleteBikeBooking(@PathVariable Integer id) {
            furnitureBookingService.deleteFurnitureBooking(id);
        }
    }

