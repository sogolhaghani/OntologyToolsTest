package ebi.ac.uk.ontologytoolstest.gateway;

import ebi.ac.uk.ontologytoolstest.gateway.dto.OntologyDTO;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class OntologyLookupServiceGateway {

  private final RestTemplate restTemplate;
  private static final String BASE_URL="https://www.ebi.ac.uk/ols4/api/ontologies/";


  public Optional<OntologyDTO> fetchByOntologyId(String ontologyId) {
    try {
      ResponseEntity<OntologyDTO> response = restTemplate.getForEntity(BASE_URL + ontologyId, OntologyDTO.class);
      if (response.getStatusCode().is2xxSuccessful()) {
        return Optional.of(response.getBody());
      }
      log.warn("OntologyLookupService response with status : {}",response.getStatusCode());
    }catch (Exception e){
      log.error("Fetch failed. {}", e.getMessage(), e);
    }
    return Optional.empty();
  }
}
