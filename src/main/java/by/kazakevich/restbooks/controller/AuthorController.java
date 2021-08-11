package by.kazakevich.restbooks.controller;

import by.kazakevich.restbooks.dto.response.AuthorResponse;
import by.kazakevich.restbooks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/author")
public class AuthorController {

  private final AuthorService authorService;

  @GetMapping("/{id}")
  public ResponseEntity<AuthorResponse> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(authorService.getById(id), HttpStatus.OK);
  }
}
