package bernabemanresa.example.open_closed;

import java.util.List;

import bernabemanresa.domain.Book;
import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentAdder;
import bernabemanresa.domain.ports.DocumentDeletion;
import bernabemanresa.domain.ports.DocumentFinder;
import bernabemanresa.domain.valueobjects.DocumentIdentifier;
import bernabemanresa.domain.valueobjects.DocumentTitle;
import bernabemanresa.domain.valueobjects.Editorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class Tests {

  @Autowired
  DocumentAdder documentAdder;
  @Autowired
  DocumentFinder documentFinder;
  @Autowired
  DocumentDeletion documentDeletion;

  private static Book getBook(String number) {
    return Book.builder()
        .editorial(Editorial.builder().value("Fantastic Books").build())
        .title(DocumentTitle.builder().value("2001").build())
        .documentIdentifier(new DocumentIdentifier(number))
        .build();
  }

  @BeforeEach
  void beforeAll() throws Exception {
    documentDeletion.delete(getBook("1"));
  }

  @Test
  void saveDocument() throws Exception {
    documentAdder.add(getBook("1"));
  }

  @Test
  void getDocument() throws Exception {
    documentAdder.add(getBook("1"));
    Document d = documentFinder.find(getBook("1"));
    Assertions.assertEquals(getBook("1"), d);
  }

  @Test
  void getAllDocuments() throws Exception {
    documentAdder.add(getBook("1"));
    documentAdder.add(getBook("2"));
    final List<Document> retrievedDocuments = documentFinder.findAll();
    Assertions.assertEquals(2, retrievedDocuments.size());

    Assertions.assertEquals(1,
        retrievedDocuments.stream()
            .filter(document -> document.getDocumentIdentifier().value().equals("1"))
            .count());
    Assertions.assertEquals(1,
        retrievedDocuments.stream()
            .filter(document -> document.getDocumentIdentifier().value().equals("2"))
            .count());

  }

  @Test
  void deleteDocument() throws Exception {
    documentAdder.add(getBook("1"));
    documentAdder.add(getBook("2"));
    final List<Document> retrievedDocuments = documentFinder.findAll();
    Assertions.assertEquals(2, retrievedDocuments.size());
    documentDeletion.delete(getBook("1"));
    Assertions.assertEquals(1, retrievedDocuments.size());
    documentDeletion.delete(getBook("2"));
    Assertions.assertTrue(retrievedDocuments.isEmpty());
  }
}
