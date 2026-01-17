package mozay.library_management_system_backend.Service;

import mozay.library_management_system_backend.Entity.Book;
import mozay.library_management_system_backend.Repository.BookRepository;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }
    public Book createBook(Book book) throws Exception {
        log.info(" Adding new book with title: {} ", book.getTitle());

        // if book exists by isbn, error
        Optional<Book> existing =  bookRepository.findByIsbn(book.getIsbn());
        if(existing.isPresent()){
            throw new BadRequestException("Book with isbn already exists");
        }

        book.setId(null);
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setIsbn(book.getIsbn());
        book.setPublishedDate(book.getPublishedDate());

        Book addedBook =  bookRepository.save(book);
        log.info("Book '{}' has been created", addedBook.getTitle());
        return addedBook;
    }

    public List getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishedDate(bookDetails.getPublishedDate());

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public Page<Book> searchByAuthor(String author, Pageable pageable) {
        return bookRepository.findByAuthorContainingIgnoreCase(author, pageable);
    }

}
