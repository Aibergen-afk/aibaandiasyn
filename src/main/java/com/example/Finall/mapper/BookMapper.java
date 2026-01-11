package com.example.Finall.mapper;

import com.example.Finall.dto.BookDto;
import com.example.Finall.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorId", source = "author.id")
    BookDto toDto(Book book);
}