package com.example.furniturerental.backend.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FurnitureBookingPojo {
    private Integer id;
    private Integer furnitureId;
    private Integer userId;
    private LocalDateTime rentalStartdateTime;
    private LocalDateTime rentalEnddateTime;
    private Double totalAmount;
}
