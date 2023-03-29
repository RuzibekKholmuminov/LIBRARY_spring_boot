package com.example.controller;

import com.example.dto.Bookdto;
import com.example.dto.StudentDTO;
import com.example.service.BookService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;
    private List<Bookdto> bookList = new LinkedList<>();

    public BookController() {
        Bookdto s1 = new Bookdto();
        s1.setId(1);
        s1.setAmount(1200);
        s1.setTitle("Qizil");
        s1.setAuthor("Umid");
        s1.setVisible(true);
        s1.setPublishYear(LocalDate.ofEpochDay(2020 - 03 - 01));
        bookList.add(s1);
    }

    @GetMapping("/list")
    public List<Bookdto> getBookList() {
        return bookList;
    }

    @GetMapping(value = "/get/{id}")
    public Bookdto getById(@PathVariable("id") String id) {
        Optional<Bookdto> optional = bookList.stream().filter(bookdto -> bookdto.getId().equals(id)).findAny();
        return optional.orElse(null);
    }

    @PostMapping(value = "/create")
    public Bookdto create(@RequestBody Bookdto bookdto) {
        return bookService.crateBook(bookdto);
    }


    @PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<Bookdto> list) {
        for (Bookdto dto : list) {
            dto.setId(1);
            bookList.add(dto);
        }
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody Bookdto bookdto) {
        for (Bookdto dto : bookList) {
            if (dto.getId().equals(id)) {
                dto.setAmount(bookdto.getAmount());
                dto.setTitle(bookdto.getTitle());
                dto.setAuthor(bookdto.getAuthor());
                dto.setVisible(bookdto.getVisible());
                dto.setPublishYear(bookdto.getPublishYear());
                bookList.add(dto);
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return bookList.removeIf(bookdto -> bookdto.getId().equals(id));
    }
}
