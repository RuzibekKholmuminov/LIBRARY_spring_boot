package com.example.dto;

import com.example.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
@Getter
@Setter
public class StudentBookDto {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDate createdDate;
    private Status status;
    private LocalDate returnedDate;
    private Duration duration;
}
