package by.kazakevich.restbooks.mapper;

import by.kazakevich.restbooks.domain.Book;
import by.kazakevich.restbooks.dto.request.CreateBookRequest;
import by.kazakevich.restbooks.dto.response.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDtoToEntityMapper {

  BookResponse bookEntityToDto(Book book);

  Book bookDtoToEntity(CreateBookRequest createBookRequest);
}
