package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record Company(String value) {
  public Company {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(this.getClass().getName() + " value can't be null");
    }
  }
}
