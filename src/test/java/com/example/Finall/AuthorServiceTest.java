package com.example.Finall;

import com.example.Finall.dto.AuthorDto;
import com.example.Finall.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void getAllAuthorsTest() {
        List<AuthorDto> authors = authorService.findAll();

        Assertions.assertNotNull(authors);

        if (!authors.isEmpty()) {
            for (AuthorDto dto : authors) {
                Assertions.assertNotNull(dto);
                Assertions.assertNotNull(dto.getId());
                Assertions.assertNotNull(dto.getName());
            }
        }
    }

    @Test
    void createAuthorTest() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("Test Author");

        AuthorDto created = authorService.create(authorDto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals("Test Author", created.getName());
    }

    @Test
    void updateAuthorTest() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("Old Name");

        AuthorDto created = authorService.create(authorDto);

        AuthorDto updateDto = new AuthorDto();
        updateDto.setName("New Name");

        AuthorDto updated = authorService.update(created.getId(), updateDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals("New Name", updated.getName());

        AuthorDto check = authorService.findAll()
                .stream()
                .filter(a -> a.getId().equals(created.getId()))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(check);
        Assertions.assertEquals("New Name", check.getName());
    }
}
