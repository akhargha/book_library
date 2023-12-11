package edu.trincoll.book_library.controllers;
import edu.trincoll.book_library.dao.BookRepository;
import edu.trincoll.book_library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342") // Allow your frontend's origin
public class BookController {
    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable Long id){
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBookByID(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/books/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> book = repository.findByIsbn(isbn);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/books/isbn/{isbn}")
    public ResponseEntity<?> deleteBookByIsbn(@PathVariable String isbn) {
        return repository.findByIsbn(isbn)
                .map(book -> {
                    repository.delete(book);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        repository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(location).body(book);
    }
}
