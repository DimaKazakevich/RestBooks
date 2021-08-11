package by.kazakevich.restbooks.controller;

import by.kazakevich.restbooks.dto.request.SearchBookRequest;
import by.kazakevich.restbooks.dto.request.UpdateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import by.kazakevich.restbooks.dto.response.MessageResponse;
import by.kazakevich.restbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

  private final BookService bookService;

  @GetMapping("/{id}")
  public ResponseEntity<BookResponse> getById(@PathVariable Integer id) {
    BookResponse bookResponse = bookService.getById(id);
    return new ResponseEntity<>(bookResponse, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id) {
    bookService.deleteById(id);
    return new ResponseEntity<>(new MessageResponse("Deleted successfully"), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Page<BookResponse>> search(Pageable pageable,
      SearchBookRequest searchBookRequest) {
    return new ResponseEntity<>(bookService.search(searchBookRequest, pageable), HttpStatus.OK);
  }
}
