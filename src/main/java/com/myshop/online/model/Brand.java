package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "brands")
public class Brand{
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    @Column
    private String brandName;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("name ASC")
    List<Product> products;
}