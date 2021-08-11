package by.kazakevich.restbooks.repository;

import by.kazakevich.restbooks.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  Page<Book> findByTitleContaining(String title, Pageable pageable);

  Page<Book> findAllByPublishingYear(Long publishingYear, Pageable pageable);

  Page<Book> findByTitleContainingAndPublishingYear(String title, Long publishingYear,
      Pageable pageable);
}
