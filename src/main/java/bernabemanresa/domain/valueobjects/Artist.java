package bernabemanresa.domain.valueobjects;

public record Artist(String value) {
  public Artist {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("El valor no puede estar vacío");
    }
  }
}
