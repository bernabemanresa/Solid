package bernabemanresa.application;

import java.util.List;

import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentFinder;
import bernabemanresa.domain.ports.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDocumentFinder implements DocumentFinder {

  DocumentsRepository documentsRepository;

  @Autowired
  public DefaultDocumentFinder(DocumentsRepository documentsRepository) {
    this.documentsRepository = documentsRepository;
  }

  @Override
  public Document find(Document document) {
    return documentsRepository.getById(document.getId());
  }

  @Override
  public List<Document> findAll() {
    return documentsRepository.getAll();
  }

}
