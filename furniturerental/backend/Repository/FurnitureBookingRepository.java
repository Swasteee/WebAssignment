package com.example.furniturerental.backend.Repository;

import com.example.furniturerental.backend.Entity.FurnitureBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureBookingRepository  extends JpaRepository<FurnitureBookEntity,Integer> {

}
