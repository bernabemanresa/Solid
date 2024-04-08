package bernabemanresa.example.open_closed;

import java.util.List;

import bernabemanresa.application.DefaultDocumentAdder;
import bernabemanresa.domain.Book;
import bernabemanresa.domain.Document;
import bernabemanresa.domain.ports.DocumentAdder;
import bernabemanresa.domain.ports.DocumentDeletion;
import bernabemanresa.domain.ports.DocumentFinder;
import bernabemanresa.domain.ports.DocumentsRepository;
import bernabemanresa.domain.valueobjects.DocumentIdentifier;
import bernabemanresa.domain.valueobjects.DocumentTitle;
import bernabemanresa.domain.valueobjects.Editorial;
import bernabemanresa.infrastucture.InMemoryDocumentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class TestsUnitatios {

  @MockBean
  DocumentsRepository documentsRepository;
  @InjectMocks
  @Autowired
  DefaultDocumentAdder documentAdder;



  private static Book getBook(String number) {
    return Book.builder()
        .editorial(Editorial.builder().value("Fantastic Books").build())
        .title(DocumentTitle.builder().value("2001").build())
        .documentIdentifier(new DocumentIdentifier(number))
        .build();
  }

  @Test
  void saveDocument() throws Exception {
    documentAdder.add(getBook("1"));
  }

}
