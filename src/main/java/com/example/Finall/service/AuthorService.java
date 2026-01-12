package com.example.Finall.service;

import com.example.Finall.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto create(AuthorDto dto);
    List<AuthorDto> findAll();
    AuthorDto update(Long id, AuthorDto dto);
    void delete(Long id);
}