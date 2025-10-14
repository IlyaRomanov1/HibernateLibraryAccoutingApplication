package ru.romanov.springcourse.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.romanov.springcourse.models.Book;
import ru.romanov.springcourse.models.Person;

import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public List<Book> getPersonBooks(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, id);
        Hibernate.initialize(person.getBooks());
        return person.getBooks();
    }
}
