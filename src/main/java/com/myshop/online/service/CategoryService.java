package com.myshop.online.service;

import com.myshop.online.dto.CategoryDTO;
import com.myshop.online.exception.ResourceNotFoundException;
import com.myshop.online.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Page<CategoryDTO> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(CategoryDTO::from);
        //.toList();
    }

    public CategoryDTO getCategory(int id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", id));
        return CategoryDTO.from(category);
    }
}
