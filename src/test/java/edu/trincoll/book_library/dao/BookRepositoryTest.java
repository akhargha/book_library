package edu.trincoll.book_library.dao;

import edu.trincoll.book_library.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void countBooks() {
        assertEquals(2, repository.count());
    }

    @Test
    void findById() {
        assertTrue(repository.findById(1L).isPresent());
    }

    @Test
    void saveBook() {
        Book newBook = new Book("New Book", "New Author", "1234567890123", LocalDate.now());
        repository.save(newBook);
        assertNotNull(newBook.getId()); // Check if the book is saved and ID is generated
        assertEquals(3, repository.count());
    }
}
