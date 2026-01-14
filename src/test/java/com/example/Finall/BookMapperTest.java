package com.example.Finall;

import com.example.Finall.dto.BookDto;
import com.example.Finall.mapper.BookMapper;
import com.example.Finall.model.Author;
import com.example.Finall.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper mapper;

    @Test
    void toDtoTest() {
        Author author = new Author();
        author.setId(10L);
        author.setName("Author");

        Book entity = new Book();
        entity.setId(1L);
        entity.setTitle("Test Book");
        entity.setYear(2024);
        entity.setAuthor(author);

        BookDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getTitle(), dto.getTitle());
        Assertions.assertEquals(entity.getYear(), dto.getYear());
        Assertions.assertEquals(author.getId(), dto.getAuthorId());
    }
}
