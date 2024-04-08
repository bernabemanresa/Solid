package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record DocumentTitle(String value) {

  public DocumentTitle {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(this.getClass().getName() + " value can't be null");
    }
  }
}
