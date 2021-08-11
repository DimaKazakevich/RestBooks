package by.kazakevich.restbooks.service;

import by.kazakevich.restbooks.dto.response.AuthorResponse;

public interface AuthorService {

  AuthorResponse getById(Integer id);
}
