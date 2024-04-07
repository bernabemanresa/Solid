package bernabemanresa.infrastucture;

import java.util.ArrayList;
import java.util.List;

import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDocumentRepository implements DocumentsRepository {

  private List<Document> documents = new ArrayList<>();

  @Override
  public Document getById(String id) {
    return documents.stream()
        .filter(doc -> doc.getDocumentIdentifier().value().equals(id))
        .findFirst().orElseThrow();
  }

  @Override
  public List<Document> getAll() {
    return documents;
  }

  @Override
  public void save(Document document) {
    documents.add(document);
  }

  @Override
  public void delete(Document document) {
    documents.removeIf(doc -> doc.getDocumentIdentifier().equals(document.getDocumentIdentifier()));
  }
}
