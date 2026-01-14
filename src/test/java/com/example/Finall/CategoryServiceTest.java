package com.example.Finall;

import com.example.Finall.dto.CategoryDto;
import com.example.Finall.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllCategoriesTest() {
        List<CategoryDto> categories = categoryService.findAll();

        Assertions.assertNotNull(categories);

        if (!categories.isEmpty()) {
            for (CategoryDto dto : categories) {
                Assertions.assertNotNull(dto);
                Assertions.assertNotNull(dto.getId());
                Assertions.assertNotNull(dto.getName());
            }
        }
    }

    @Test
    void createCategoryTest() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Test Category");

        CategoryDto created = categoryService.create(categoryDto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals("Test Category", created.getName());
    }

    @Test
    void updateCategoryTest() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Old Category");

        CategoryDto created = categoryService.create(categoryDto);

        CategoryDto updateDto = new CategoryDto();
        updateDto.setName("New Category");

        CategoryDto updated =
                categoryService.update(created.getId(), updateDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals("New Category", updated.getName());

        CategoryDto check = categoryService.findAll()
                .stream()
                .filter(c -> c.getId().equals(created.getId()))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(check);
        Assertions.assertEquals("New Category", check.getName());
    }
}
