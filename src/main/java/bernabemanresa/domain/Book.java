package bernabemanresa.domain;

public class Book extends Document {

  private String title;
  private String editorial;


  public Book(String id, String title, String editorial) {
    super(id);
    this.title = title;
    this.editorial = editorial;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book book)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    if (!title.equals(book.title)) {
      return false;
    }
    return editorial.equals(book.editorial);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + title.hashCode();
    result = 31 * result + editorial.hashCode();
    return result;
  }
}
