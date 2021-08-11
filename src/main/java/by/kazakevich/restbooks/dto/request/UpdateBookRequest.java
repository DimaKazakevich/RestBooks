package by.kazakevich.restbooks.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UpdateBookRequest extends CreateBookRequest {
  private Integer id;
}
