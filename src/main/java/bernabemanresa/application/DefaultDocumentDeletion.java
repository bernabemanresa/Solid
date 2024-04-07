package bernabemanresa.application;

import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentDeletion;
import bernabemanresa.domain.ports.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDocumentDeletion implements DocumentDeletion {
  DocumentsRepository documentsRepository;

  @Autowired
  public DefaultDocumentDeletion(DocumentsRepository documentsRepository) {
    this.documentsRepository = documentsRepository;
  }

  @Override
  public void delete(Document document) {
    documentsRepository.delete(document);
  }
}
