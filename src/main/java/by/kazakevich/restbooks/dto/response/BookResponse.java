package by.kazakevich.restbooks.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/*@NoArgsConstructor*/
@Data
public class BookResponse {

  private Long id;

  private String title;

  private Integer publishingYear;
}
