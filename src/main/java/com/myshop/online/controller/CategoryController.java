package com.myshop.online.controller;

import com.myshop.online.dto.CategoryDTO;
import com.myshop.online.dto.ProductDTO;
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
    public List<CategoryDTO> getCategories(Pageable pageable) {
        return categoryService.getCategories(pageable).getContent();
    }



    @GetMapping("/{categoryId}/products")
    public List<ProductDTO> getAllById(@PathVariable int categoryId, Pageable pageable) {
        return productService.findAllByCategoryId(categoryId, pageable).getContent();
    }


}
