package ebi.ac.uk.ontologytoolstest;

import ebi.ac.uk.ontologytoolstest.controller.OntologyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OntologyToolsTestApplicationTests {

  @Autowired
  private OntologyController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }

}
