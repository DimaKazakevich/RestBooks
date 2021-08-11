package by.kazakevich.restbooks.dto.response;

import by.kazakevich.restbooks.domain.Book;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorResponse {

  private Integer id;

  private String fullName;

  private String country;
}
