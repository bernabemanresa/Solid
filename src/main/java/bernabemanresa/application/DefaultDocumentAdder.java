package bernabemanresa.application;

import bernabemanresa.domain.ports.DocumentAdder;
import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDocumentAdder implements DocumentAdder {

  DocumentsRepository documentsRepository;


  @Autowired
  public DefaultDocumentAdder(DocumentsRepository documentsRepository) {
    this.documentsRepository = documentsRepository;
  }

  @Override
  public void add(Document document) {
    documentsRepository.save(document);
  }
}
