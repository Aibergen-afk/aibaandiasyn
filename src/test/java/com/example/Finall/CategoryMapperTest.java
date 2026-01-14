package com.example.Finall;

import com.example.Finall.dto.CategoryDto;
import com.example.Finall.mapper.CategoryMapper;
import com.example.Finall.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper mapper;

    @Test
    void toEntityTest() {
        CategoryDto dto = new CategoryDto();
        dto.setId(1L);
        dto.setName("Test Category");

        Category entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getName(), entity.getName());
    }

    @Test
    void toDtoTest() {
        Category entity = new Category();
        entity.setId(1L);
        entity.setName("Entity Category");

        CategoryDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getName(), dto.getName());
    }

    @Test
    void toDtoListTest() {
        Category c1 = new Category();
        c1.setId(1L);
        c1.setName("C1");

        Category c2 = new Category();
        c2.setId(2L);
        c2.setName("C2");

        List<Category> entities = List.of(c1, c2);
        List<CategoryDto> dtos = entities.stream()
                .map(mapper::toDto)
                .toList();

        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(entities.size(), dtos.size());
    }
}
