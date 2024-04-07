package bernabemanresa.domain;

public class CD extends Document{

  private String artist;
  private String company;

  public CD(String id, String artist, String company) {
    super(id);
    this.artist = artist;
    this.company = company;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CD cd)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    if (!artist.equals(cd.artist)) {
      return false;
    }
    return company.equals(cd.company);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + artist.hashCode();
    result = 31 * result + company.hashCode();
    return result;
  }
}
