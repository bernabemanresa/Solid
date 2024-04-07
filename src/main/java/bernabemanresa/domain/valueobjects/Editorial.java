package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record Editorial(String value) {

  public Editorial {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("El valor no puede estar vacío");
    }
  }

}
