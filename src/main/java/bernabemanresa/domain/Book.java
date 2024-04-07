package bernabemanresa.domain;

import bernabemanresa.domain.valueobjects.DocumentIdentifier;
import bernabemanresa.domain.valueobjects.DocumentTitle;
import bernabemanresa.domain.valueobjects.Editorial;
import lombok.Builder;
import lombok.Data;


@Data
public class Book extends Document {

  private DocumentTitle title;
  private Editorial editorial;

  @Builder
  public Book(DocumentIdentifier documentIdentifier, DocumentTitle title, Editorial editorial) {
    super(documentIdentifier);
    this.title = title;
    this.editorial = editorial;
  }

}
