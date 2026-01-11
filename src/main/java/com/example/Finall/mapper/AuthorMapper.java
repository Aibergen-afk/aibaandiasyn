package com.example.Finall.mapper;

import com.example.Finall.dto.AuthorDto;
import com.example.Finall.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorDto dto);
    AuthorDto toDto(Author author);
}
