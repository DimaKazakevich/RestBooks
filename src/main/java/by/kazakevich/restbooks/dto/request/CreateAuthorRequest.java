package by.kazakevich.restbooks.dto.request;

import javax.persistence.Column;
import lombok.Data;

@Data
public class CreateAuthorRequest {

  private Integer id;

  private String fullName;

  private String country;
}
