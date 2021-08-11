package by.kazakevich.restbooks.controller;

import by.kazakevich.restbooks.dto.request.CreateBookRequest;
import by.kazakevich.restbooks.dto.request.UpdateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import by.kazakevich.restbooks.dto.response.MessageResponse;
import by.kazakevich.restbooks.security.UserPrincipal;
import by.kazakevich.restbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/book")
public class BookAdminController {

  private final BookService bookService;

  @PostMapping
  public ResponseEntity<MessageResponse> add(@AuthenticationPrincipal UserPrincipal user,
      @RequestBody CreateBookRequest createBookRequest) {
    bookService.create(user, createBookRequest);
    return new ResponseEntity<>(new MessageResponse("Created successfully"), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<BookResponse> update(@RequestBody UpdateBookRequest updateBookRequest) {

    return new ResponseEntity<>(bookService.update(updateBookRequest), HttpStatus.OK);
  }
}
