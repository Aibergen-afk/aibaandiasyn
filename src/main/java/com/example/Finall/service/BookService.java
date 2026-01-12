package com.example.Finall.service;

import com.example.Finall.dto.BookDto;
import java.util.List;

public interface BookService {
    BookDto create(BookDto dto);
    List<BookDto> findAll();
    BookDto update(Long id, BookDto dto);
    void delete(Long id);
}