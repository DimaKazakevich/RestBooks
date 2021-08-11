package by.kazakevich.restbooks.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchBookRequest {

  private String title;

  private Long publishingYear;
}
