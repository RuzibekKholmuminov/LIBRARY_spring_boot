package com.example.controller;

import com.example.dto.StudentBookDto;
import com.example.enums.Status;
import com.example.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/studentBook")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;
    private List<StudentBookDto> studentBookDtoLinkedList = new LinkedList<>();

    public StudentBookController() {
        StudentBookDto s1 = new StudentBookDto();
        s1.setId(1);
        s1.setReturnedDate(LocalDate.ofEpochDay(2023 - 13 - 03));
        s1.setDuration(Duration.ofDays(15));
        s1.setCreatedDate(LocalDate.ofEpochDay(2020 - 01 - 01));
        s1.setStatus(Status.TAKEN);
        s1.setStudent_id(1);
        s1.setBook_id(2);
        studentBookDtoLinkedList.add(s1);
    }

    @GetMapping("/list")
    public List<StudentBookDto> getBookList() {
        return studentBookDtoLinkedList;
    }

    @GetMapping(value = "/get/{id}")
    public StudentBookDto getById(@PathVariable("id") String id) {
        Optional<StudentBookDto> optional = studentBookDtoLinkedList.stream().filter(bookdto -> bookdto.getId().equals(id)).findAny();
        return optional.orElse(null);
    }

    @PostMapping(value = "/create")
    public StudentBookDto create(@RequestBody StudentBookDto studentBookDto) {
        return studentBookService.crate(studentBookDto);
    }


    @PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<StudentBookDto> list) {
        for (StudentBookDto dto : list) {
            dto.setId(1);
            studentBookDtoLinkedList.add(dto);
        }
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody StudentBookDto studentBookDto) {
        for (StudentBookDto dto : studentBookDtoLinkedList) {
            if (dto.getId().equals(id)) {
                dto.setReturnedDate(studentBookDto.getReturnedDate());
                dto.setDuration(studentBookDto.getDuration());
                dto.setCreatedDate(studentBookDto.getCreatedDate());
                dto.setStatus(studentBookDto.getStatus());
                dto.setStudent_id(studentBookDto.getStudent_id());
                dto.setBook_id(studentBookDto.getBook_id());
                studentBookDtoLinkedList.add(dto);

//                bookList.add(dto);
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return studentBookDtoLinkedList.removeIf(bookdto -> bookdto.getId().equals(id));
    }
}
