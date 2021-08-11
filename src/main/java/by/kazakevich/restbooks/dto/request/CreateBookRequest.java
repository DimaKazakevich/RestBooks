package by.kazakevich.restbooks.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBookRequest {

  protected String title;

  protected Long publishingYear;

  protected Integer authorId;
}
