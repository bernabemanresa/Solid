package bernabemanresa.domain.valueobjects;

public record Company(String value) {
  public Company {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("El valor no puede estar vacío");
    }
  }
}
