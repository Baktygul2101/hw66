package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "products")
public class Product{
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Column
    private String name;
    @Column
    private String image;

    @PositiveOrZero
    @Column
    private int quantity;
    @NotBlank
    @Column
    private String description;
    @Positive
    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}