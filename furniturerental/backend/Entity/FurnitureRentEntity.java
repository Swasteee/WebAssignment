package com.example.furniturerental.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Furniture_Adding")
@Getter
@Setter
public class FurnitureRentEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "furniture_seq_gen")
    @SequenceGenerator(name = "furniture_seq_gen", sequenceName = "furniture_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "furniture_brand")
    private String furnitureBrand;

    @Column(name = "type")
    private Integer type;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "furnitureimage")
    private String furnitureImage;

}
