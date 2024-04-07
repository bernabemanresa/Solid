package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record DocumentTitle(String value) {

  public DocumentTitle {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("El valor no puede estar vacío");
    }
  }
}
