package com.myshop.online.dto;

import com.myshop.online.model.Category;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class CategoryDTO {
    private int id;
    private String categoryName;
    private String description;
    public static CategoryDTO from(Category category) {
        return builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .build();
    }
}
