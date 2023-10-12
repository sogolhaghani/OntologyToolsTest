package ebi.ac.uk.ontologytoolstest.gateway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class OntologyLookupServiceGatewayTest {

  private OntologyLookupServiceGateway gateway;

  @BeforeEach
  void setupService() {
    gateway = new OntologyLookupServiceGateway(new RestTemplate());
  }

  @CsvSource({
      "efo",
      "mondo",
      "ncit",
      "go"
  })
  @ParameterizedTest
  void givenValidID_thenGatewayePresentData(String id) {
    assertThat(gateway.fetchByOntologyId(id).isPresent()).isTrue();
  }
  @CsvSource({
      "ssss",
      "xnvjkxmcnv",
      "123324"
  })
  @ParameterizedTest
  void givenInValidID_thenGatewayePresentEmpty(String id) {
    assertThat(gateway.fetchByOntologyId(id).isEmpty()).isTrue();
  }

  @Test
  void givenNullID_thenGatewayePresentEmpty() {
    assertThat(gateway.fetchByOntologyId(null).isEmpty()).isTrue();
  }
}
