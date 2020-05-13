package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "categories")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @OrderBy("name ASC")
    List<Product> products;
}