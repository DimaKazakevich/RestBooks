package by.kazakevich.restbooks.service.impl;

import by.kazakevich.restbooks.domain.Book;
import by.kazakevich.restbooks.dto.request.CreateBookRequest;
import by.kazakevich.restbooks.dto.request.SearchBookRequest;
import by.kazakevich.restbooks.dto.request.UpdateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import by.kazakevich.restbooks.mapper.BookDtoToEntityMapper;
import by.kazakevich.restbooks.repository.BookRepository;
import by.kazakevich.restbooks.security.UserPrincipal;
import by.kazakevich.restbooks.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookDtoToEntityMapper bookDtoToEntityMapper;

  @Override
  public BookResponse getById(Integer id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));

    return bookDtoToEntityMapper.bookEntityToDto(book);
  }

  @Override
  public void create(UserPrincipal userPrincipal, CreateBookRequest createBookRequest) {
    Book newBook = bookDtoToEntityMapper.bookDtoToEntity(createBookRequest);
    newBook.setUserId(userPrincipal.getId());
    bookRepository.save(newBook);
  }

  @Override
  public Page<BookResponse> search(SearchBookRequest searchBookRequest, Pageable pageable) {
    List<BookResponse> result = new ArrayList<>();
    if (searchBookRequest.getTitle() != null && searchBookRequest.getPublishingYear() == null) {
      result = bookRepository.findByTitleContaining(searchBookRequest.getTitle(), pageable).stream()
          .map(bookDtoToEntityMapper::bookEntityToDto).collect(
              Collectors.toList());
    }

    if (searchBookRequest.getTitle() == null && searchBookRequest.getPublishingYear() != null) {
      result = bookRepository
          .findAllByPublishingYear(searchBookRequest.getPublishingYear(), pageable)
          .stream()
          .map(bookDtoToEntityMapper::bookEntityToDto).collect(
              Collectors.toList());
    }

    if (searchBookRequest.getTitle() != null && searchBookRequest.getPublishingYear() != null) {
      result = bookRepository.findByTitleContainingAndPublishingYear(searchBookRequest.getTitle(),
          searchBookRequest.getPublishingYear(), pageable).stream()
          .map(bookDtoToEntityMapper::bookEntityToDto).collect(
              Collectors.toList());
    }

    return new PageImpl<>(result);
  }

  @Override
  public Page<BookResponse> searchByAuthor(String author, Pageable pageable) {
    return bookRepository.findAllByAuthorFullName(author, pageable)
        .map(bookDtoToEntityMapper::bookEntityToDto);
  }

  @Override
  public BookResponse update(UpdateBookRequest updateBookRequest) {
    Book book = bookRepository.findById(updateBookRequest.getId()).orElseThrow(
        () -> new EntityNotFoundException(
            "Book with id " + updateBookRequest.getId() + " not found"));

    book.setTitle(updateBookRequest.getTitle());
    book.setAuthorId(updateBookRequest.getAuthorId());
    book.setPublishingYear(updateBookRequest.getPublishingYear());
    bookRepository.save(book);

    return bookDtoToEntityMapper.bookEntityToDto(book);
  }

  @Override
  public void deleteById(Integer id) {
    bookRepository.deleteById(id);
  }
}
