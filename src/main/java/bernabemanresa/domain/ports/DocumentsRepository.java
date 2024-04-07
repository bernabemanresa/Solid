package bernabemanresa.domain.ports;

import java.util.List;

import bernabemanresa.domain.Document;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository {

  Document getById(String id);

  List<Document> getAll();

  void save(Document document);

  void delete(Document document);

}
