package mozay.library_management_system_backend.Repository;

import mozay.library_management_system_backend.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);

    Optional<Book> findByIsbn(String isbn);
}

