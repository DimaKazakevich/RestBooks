package by.kazakevich.restbooks.service;

import by.kazakevich.restbooks.dto.request.CreateBookRequest;
import by.kazakevich.restbooks.dto.request.SearchBookRequest;
import by.kazakevich.restbooks.dto.request.UpdateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import by.kazakevich.restbooks.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

  BookResponse getById(Integer id);

  void deleteById(Integer id);

  void create(UserPrincipal userPrincipal, CreateBookRequest createBookRequest);

  Page<BookResponse> search(SearchBookRequest searchBookRequest, Pageable pageable);

  BookResponse update(UpdateBookRequest updateBookRequest);
}
