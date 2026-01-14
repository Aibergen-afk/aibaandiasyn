package com.example.Finall;

import com.example.Finall.dto.AuthorDto;
import com.example.Finall.dto.BookDto;
import com.example.Finall.dto.CategoryDto;
import com.example.Finall.service.AuthorService;
import com.example.Finall.service.BookService;
import com.example.Finall.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllBooksTest() {
        List<BookDto> books = bookService.findAll();

        Assertions.assertNotNull(books);

        if (!books.isEmpty()) {
            for (BookDto dto : books) {
                Assertions.assertNotNull(dto.getId());
                Assertions.assertNotNull(dto.getTitle());
                Assertions.assertNotNull(dto.getAuthorId());
            }
        }
    }

    @Test
    void createBookTest() {
        AuthorDto author = new AuthorDto();
        author.setName("Book Author");
        AuthorDto savedAuthor = authorService.create(author);

        CategoryDto category = new CategoryDto();
        category.setName("Test Category");
        CategoryDto savedCategory = categoryService.create(category);

        BookDto bookDto = new BookDto();
        bookDto.setTitle("Test Book");
        bookDto.setYear(2024);
        bookDto.setAuthorId(savedAuthor.getId());
        bookDto.setCategoryIds(Set.of(savedCategory.getId()));

        BookDto created = bookService.create(bookDto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals("Test Book", created.getTitle());
        Assertions.assertEquals(savedAuthor.getId(), created.getAuthorId());
    }

    @Test
    void updateBookTest() {
        AuthorDto author = new AuthorDto();
        author.setName("Old Author");
        AuthorDto savedAuthor = authorService.create(author);

        BookDto bookDto = new BookDto();
        bookDto.setTitle("Old Title");
        bookDto.setYear(2023);
        bookDto.setAuthorId(savedAuthor.getId());
        bookDto.setCategoryIds(Set.of());

        BookDto created = bookService.create(bookDto);

        BookDto updateDto = new BookDto();
        updateDto.setTitle("New Title");
        updateDto.setYear(2025);
        updateDto.setAuthorId(savedAuthor.getId());
        updateDto.setCategoryIds(Set.of());

        BookDto updated = bookService.update(created.getId(), updateDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals("New Title", updated.getTitle());
        Assertions.assertEquals(2025, updated.getYear());
    }
}
