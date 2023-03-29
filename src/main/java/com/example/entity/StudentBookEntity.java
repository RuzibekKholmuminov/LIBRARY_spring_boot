package com.example.entity;

import com.example.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "student_book")
public class StudentBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "book_id")
    private Integer book_id;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "status")
    private Status status;
    @Column(name = "returnedDate")
    private LocalDate returnedDate;
    @Column(name = "duration")
    private Duration duration;
}
