package bernabemanresa.domain;

import bernabemanresa.domain.valueobjects.DocumentIdentifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Document {

  private DocumentIdentifier documentIdentifier;


}
