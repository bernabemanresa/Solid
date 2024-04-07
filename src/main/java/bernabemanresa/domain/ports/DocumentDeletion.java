package bernabemanresa.domain.ports;

import bernabemanresa.domain.Document;
import org.springframework.stereotype.Service;

@Service
public interface DocumentDeletion {
  void delete(Document document);

}
