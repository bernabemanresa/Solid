package bernabemanresa.domain;

public abstract class Document {

  private String id;

  protected Document(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Document document)) {
      return false;
    }

    return id.equals(document.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
