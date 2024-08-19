package com.example.furniturerental.backend.Repository;

import com.example.furniturerental.backend.Entity.FurnitureRentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRentalRepository extends JpaRepository<FurnitureRentEntity, Integer> {
    static void deletebyId() {
    }
}
