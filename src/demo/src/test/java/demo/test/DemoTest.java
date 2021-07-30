package demo.test;

import demo.data.Data;
import demo.data.IDataService;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class DemoTest {

  private final SecureRandom random = new SecureRandom();

  @Inject
  EmbeddedApplication<?> application;

  @Inject
  IDataService dataService;

  @Test
  void jpaTest() {
    Assertions.assertTrue(application.isRunning());

    long id = System.currentTimeMillis();

    LocalDateTime now = LocalDateTime.now();

    Data newData = new Data(id, random.nextInt(), "Data " + id, now.toLocalDate(), now);

    dataService.createData(newData);

    for (Data data : dataService.getAllData()) {
      System.out.println("data = " + data.toString());
    }
  }
}
