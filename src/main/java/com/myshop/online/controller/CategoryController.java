package com.myshop.online.controller;

import com.myshop.online.dto.CategoryDTO;
import com.myshop.online.service.CategoryService;
import com.myshop.online.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public List<CategoryDTO> getPlaces(Pageable pageable) {
        return categoryService.getCategories(pageable).getContent();
    }

    @GetMapping("/{id:\\d+?}")
    public CategoryDTO placePage(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

  /*  @GetMapping("/{id:\\d+}/products")
    public List<ProductDTO> getFoods(@PathVariable @Min(5) int id, Pageable pageable) {
        return productService.getProducts(id, pageable).getContent();
    }*/
}
