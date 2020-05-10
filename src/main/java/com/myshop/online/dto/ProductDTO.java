package com.myshop.online.dto;

import com.myshop.online.model.Brand;
import com.myshop.online.model.Category;
import com.myshop.online.model.Product;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDTO {

    private int id;
    private String name;
    private String image;
    private int quantity;
    private String description;
    private double price;
    private Category category;
    private Brand brand;

    public static ProductDTO from(Product product) {
        return builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .price(product.getPrice())
                //.category(CategoryDTO.from(product.getCategory()))
               // .brand(BrandDTO.from(product.getBrand()))
                .build();
    }


}
