package by.kazakevich.restbooks.mapper;

import by.kazakevich.restbooks.domain.Author;
import by.kazakevich.restbooks.dto.request.CreateAuthorRequest;
import by.kazakevich.restbooks.dto.response.AuthorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorDtoToEntityMapper {

  Author authorDtoToEntity(CreateAuthorRequest createAuthorRequest);

  AuthorResponse authorEntityToDto(Author author);
}
