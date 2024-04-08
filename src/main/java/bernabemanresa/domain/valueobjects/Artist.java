package bernabemanresa.domain.valueobjects;

import lombok.Builder;

@Builder
public record Artist(String value) {
  public Artist {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(this.getClass().getName() + " value can't be null");
    }
  }
}
