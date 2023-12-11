package edu.trincoll.book_library.dao;

import edu.trincoll.book_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
