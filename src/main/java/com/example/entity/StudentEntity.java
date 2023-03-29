package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "psw")
    private String psw;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "visible")
    private Boolean visible;
}
