package com.example.Finall.service;

import com.example.Finall.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    CategoryDto create(CategoryDto dto);
    List<CategoryDto> findAll();
    CategoryDto update(Long id, CategoryDto dto);
    void delete(Long id);
}
