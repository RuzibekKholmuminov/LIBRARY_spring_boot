package com.example.repository;

import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public BookEntity saveBook(BookEntity book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);

        transaction.commit();
        session.close();
        return book;
    }
}
