package bernabemanresa.domain.ports;

import java.util.List;

import bernabemanresa.domain.Document;
import org.springframework.stereotype.Service;

@Service
public interface DocumentFinder {

  Document find(Document document);

  List<Document> findAll();

}
