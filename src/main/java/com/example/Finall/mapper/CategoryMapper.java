package com.example.Finall.mapper;

import com.example.Finall.dto.CategoryDto;
import com.example.Finall.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryDto toDto(Category category);
}
