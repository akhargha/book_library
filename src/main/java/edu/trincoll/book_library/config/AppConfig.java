package edu.trincoll.book_library.config;

import edu.trincoll.book_library.dao.BookRepository;
import edu.trincoll.book_library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {
    private final BookRepository repository;

    @Autowired
    public AppConfig(BookRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(
                List.of(
                        new Book("The Wizard of Ooze", "John Doe", "0205080057", LocalDate.of(2022, 7, 2)),
                        new Book("Fight. Club. - A Comprehensive Guide for Barbarians", "Jane Baskett", "9781234567897", LocalDate.of(2004, 3, 6))
                )
        ).forEach(System.out::println);
    }
}
