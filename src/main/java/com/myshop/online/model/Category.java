package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "categories", catalog = "myshop")
public class Category{
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    @Column
    private String categoryName;
    @NotNull
    @Column
    private String description;

 //   @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
   // List<Product> products;

    @Override
    public String toString(){
        return categoryName;
    }
}