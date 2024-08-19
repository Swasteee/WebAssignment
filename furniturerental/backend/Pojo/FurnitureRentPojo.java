package com.example.furniturerental.backend.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FurnitureRentPojo {
    private Integer id;
    private String furnitureBrand;
    private Integer seat;
    private Integer price;
    private MultipartFile furnitureImage;
}
