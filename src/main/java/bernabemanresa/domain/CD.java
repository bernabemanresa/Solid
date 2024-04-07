package bernabemanresa.domain;

import bernabemanresa.domain.valueobjects.Artist;
import bernabemanresa.domain.valueobjects.Company;
import lombok.Data;

@Data
public class CD extends Document {

  private Artist artist;
  private Company company;

}
