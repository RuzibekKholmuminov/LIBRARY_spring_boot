package com.example.service;

import com.example.dto.StudentBookDto;
import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;
import com.example.repository.StudentbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBookService {
    @Autowired
    private StudentbookRepository studentbookRepository;

    public StudentBookDto crate(StudentBookDto dto) {
        StudentBookDto entity = new StudentBookDto();
        entity.setDuration(dto.getDuration());
        entity.setStatus(dto.getStatus());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setReturnedDate(dto.getReturnedDate());
        studentbookRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
}
