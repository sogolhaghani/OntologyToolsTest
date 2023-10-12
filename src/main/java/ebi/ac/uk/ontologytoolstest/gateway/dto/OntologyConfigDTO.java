package ebi.ac.uk.ontologytoolstest.gateway.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OntologyConfigDTO implements Serializable {

  private String id;
  private String versionIri;
  private String namespace;
  private String preferredPrefix;
  private String title;
  private String description;
  private String homepage;
  private String version;
  private String mailingList;
  private String tracker;
  private String logo;
  private List<String> creators;
  private String annotations;
  private String fileLocation;
  private Boolean oboSlims;
  private String labelProperty;
  private List<String> definitionProperties;
  private List<String> synonymProperties;
  private List<String> hierarchicalProperties;
  private List<String> baseUris;
  private List<String> hiddenProperties;
  private List<String> preferredRootTerms;
  private Boolean isSkos;
  private Boolean allowDownload;

}
