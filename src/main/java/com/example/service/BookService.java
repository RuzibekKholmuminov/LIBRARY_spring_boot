package com.example.service;

import com.example.dto.Bookdto;
import com.example.dto.StudentDTO;
import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Bookdto crateBook(Bookdto dto) {
        BookEntity entity = new BookEntity();
        entity.setAmount(dto.getAmount());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setVisible(dto.getVisible());
        entity.setPublishYear(LocalDateTime.now().toLocalDate());
        bookRepository.saveBook(entity);
        dto.setId(entity.getId());
        return dto;
    }
}
