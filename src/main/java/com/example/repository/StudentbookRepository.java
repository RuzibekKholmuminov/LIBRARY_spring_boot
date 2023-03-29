package com.example.repository;

import com.example.dto.StudentBookDto;
import com.example.entity.BookEntity;
import com.example.enums.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
@Repository
public class StudentbookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentBookDto save(StudentBookDto dto) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return dto;
    }
}
