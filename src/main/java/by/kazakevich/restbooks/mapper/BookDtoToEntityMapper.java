package by.kazakevich.restbooks.mapper;

import by.kazakevich.restbooks.domain.Book;
import by.kazakevich.restbooks.dto.request.CreateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookDtoToEntityMapper {

  /*@Mapping(target = "title", source = "title")*/
/*  @Mappings({
      @Mapping(target = "userId", ignore = true),
      @Mapping(target = "authorId", ignore = true),
      @Mapping(target = "user", ignore = true),
      @Mapping(target = "author", ignore = true),
  })*/
  /*@Mapping(source = "title", target = "title")*/
  BookResponse bookEntityToDto(Book book);

/*  @Mappings({
      @Mapping(target = "userId", ignore = true),
      @Mapping(target = "authorId", ignore = true),
      @Mapping(target = "user", ignore = true),
      @Mapping(target = "author", ignore = true),
  })*/
  /*@Mapping(source = "title", target = "title")*/
  Book bookDtoToEntity(CreateBookRequest createBookRequest);
}
