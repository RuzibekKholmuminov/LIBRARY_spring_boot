package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Bookdto {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Integer amount;
    private Boolean visible;
}
