package ebi.ac.uk.ontologytoolstest.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class OntologyModel {
  @Id
  private String ontologyId;
  private String title;
  private String description;
  private List<String> definitionProperties;
  private List<String> synonymProperties;
}
