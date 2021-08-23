package by.kazakevich.restbooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import by.kazakevich.restbooks.domain.Author;
import by.kazakevich.restbooks.dto.response.AuthorResponse;
import by.kazakevich.restbooks.mapper.AuthorDtoToEntityMapper;
import by.kazakevich.restbooks.repository.AuthorRepository;
import by.kazakevich.restbooks.service.impl.AuthorServiceImpl;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

  @Mock
  private AuthorRepository authorRepository;
  @Mock
  private AuthorDtoToEntityMapper authorDtoToEntityMapper;

  @InjectMocks
  private AuthorServiceImpl authorService;

  AuthorResponse authorResponse;
  Author author;

  private static final int AUTHOR_ID = 1;

  @BeforeEach
  public void setup() {
    author = Author.builder()
        .id(AUTHOR_ID)
        .fullName("Svetlana Alexievich")
        .country("Belarus")
        .build();

    authorResponse = AuthorResponse.builder()
        .id(AUTHOR_ID)
        .fullName("Svetlana Alexievich")
        .country("Belarus")
        .build();
  }

  @Test
  public void getAuthorByIdShouldReturnFilledDto() {
    doReturn(Optional.of(author)).when(authorRepository).findById(AUTHOR_ID);

    doReturn(authorResponse).when(authorDtoToEntityMapper).authorEntityToDto(author);

    AuthorResponse response = authorService.getById(AUTHOR_ID);

    verify(authorRepository, times(1)).findById(AUTHOR_ID);
    verify(authorDtoToEntityMapper, times(1)).authorEntityToDto(author);

    assertEquals(response, authorResponse);
  }

  @Test
  public void getFlightByIdShouldThrowExceptionTest() {
    assertThrows(
        EntityNotFoundException.class,
        () -> authorService.getById(AUTHOR_ID));

    verify(authorRepository, times(1)).findById(AUTHOR_ID);
    verify(authorDtoToEntityMapper, times(0))
        .authorEntityToDto(any(Author.class));
  }
}
