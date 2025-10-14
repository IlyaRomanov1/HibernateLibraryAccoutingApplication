package ru.romanov.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanov.springcourse.models.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}
