package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record DocumentIdentifier(String value) {
  public DocumentIdentifier {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(this.getClass().getName() + " value can't be null");
    }
  }
}
