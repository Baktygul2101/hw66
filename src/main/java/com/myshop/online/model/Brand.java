package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "brands", catalog = "myshop")
public class Brand{
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    @Column
    private String brandName;

 //   @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
   // List<Product> products;

    @Override
    public String toString(){
        return brandName;
    }
}