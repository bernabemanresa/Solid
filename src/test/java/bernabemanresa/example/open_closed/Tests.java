package bernabemanresa.example.open_closed;

import java.util.List;

import bernabemanresa.domain.Book;
import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentAdder;
import bernabemanresa.domain.ports.DocumentDeletion;
import bernabemanresa.domain.ports.DocumentFinder;
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

  @BeforeEach
  void beforeAll() {
    documentDeletion.delete(new Book("1", "2001", "Fantastic Books"));
    documentDeletion.delete(new Book("2", "Me, Robot", "Fantastic Books"));
  }

  @Test
  void saveDocument() {
    Document book = new Book("1", "2001", "Fantastic Books");
  }

  @Test
  void getDocument() {
    Document book = new Book("1", "2001", "Fantastic Books");
    documentAdder.add(book);
    Document d = documentFinder.find(book);
    Assertions.assertEquals(book, d);
  }

  @Test
  void getAllDocuments() {
    documentAdder.add(new Book("1", "2001", "Fantastic Books"));
    documentAdder.add(new Book("2", "Me, Robot", "Fantastic Books"));
    final List<Document> retrievedDocuments = documentFinder.findAll();
    Assertions.assertEquals(2, retrievedDocuments.size());

    Assertions.assertEquals(1,
        retrievedDocuments.stream().filter(document -> document.getId().equals("1")).count());
    Assertions.assertEquals(1,
        retrievedDocuments.stream().filter(document -> document.getId().equals("2")).count());

  }
  @Test
  void deleteDocument(){
    documentAdder.add(new Book("1", "2001", "Fantastic Books"));
    documentAdder.add(new Book("2", "Me, Robot", "Fantastic Books"));
    final List<Document> retrievedDocuments = documentFinder.findAll();
    Assertions.assertEquals(2, retrievedDocuments.size());
    documentDeletion.delete(new Book("1", "2001", "Fantastic Books"));
    Assertions.assertEquals(1, retrievedDocuments.size());
    documentDeletion.delete(new Book("2", "Me, Robot", "Fantastic Books"));
    Assertions.assertTrue(retrievedDocuments.isEmpty());
  }


}
