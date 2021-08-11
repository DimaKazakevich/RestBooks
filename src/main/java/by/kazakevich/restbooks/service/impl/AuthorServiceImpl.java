package by.kazakevich.restbooks.service.impl;

import by.kazakevich.restbooks.domain.Author;
import by.kazakevich.restbooks.dto.response.AuthorResponse;
import by.kazakevich.restbooks.mapper.AuthorDtoToEntityMapper;
import by.kazakevich.restbooks.repository.AuthorRepository;
import by.kazakevich.restbooks.service.AuthorService;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorDtoToEntityMapper authorDtoToEntityMapper;

  @Override
  public AuthorResponse getById(Integer id) {
    Author book = authorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + " not found"));

    return authorDtoToEntityMapper.authorEntityToDto(book);
  }
}
