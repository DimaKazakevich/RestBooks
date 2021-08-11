package by.kazakevich.restbooks.mapper;

import by.kazakevich.restbooks.domain.Author;
import by.kazakevich.restbooks.dto.request.CreateAuthorRequest;
import by.kazakevich.restbooks.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorDtoToEntityMapper {

  /*@Mapping(target = "country", source = "country")*/
  Author authorDtoToEntity(CreateAuthorRequest createAuthorRequest);

 /* @Mapping(target = "country", source = "country")*/
  AuthorResponse authorEntityToDto(Author author);
}
