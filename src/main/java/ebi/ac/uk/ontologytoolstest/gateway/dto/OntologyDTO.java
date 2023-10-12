package ebi.ac.uk.ontologytoolstest.gateway.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class OntologyDTO implements Serializable {

  private String ontologyId;
  private String lang;
  private Set<String> languages;
  private Date loaded;
  private Date updated;
  private String status;
  private String message;
  private String version;
  private String fileHash;
  private Long loadAttempts;
  private Long numberOfTerms;
  private Long numberOfProperties;
  private Long numberOfIndividuals;
  private OntologyConfigDTO config;
  private List<String> baseUris;
  private LinkDTO links;

}