package bernabemanresa.domain.ports;

import bernabemanresa.domain.Document;
import org.springframework.stereotype.Service;

@Service
public interface DocumentAdder {

  public void add(Document document);

}
