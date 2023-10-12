package ebi.ac.uk.ontologytoolstest.service.mapper;

import ebi.ac.uk.ontologytoolstest.gateway.dto.OntologyDTO;
import ebi.ac.uk.ontologytoolstest.model.OntologyModel;
import org.springframework.stereotype.Service;

@Service
public class OntologyMapper {

  public  OntologyModel mapToModel(OntologyDTO ontologyGWDTO){
    return OntologyModel.builder()
        .ontologyId(ontologyGWDTO.getOntologyId())
        .title(ontologyGWDTO.getConfig().getTitle())
        .description(ontologyGWDTO.getConfig().getDescription())
        .definitionProperties(ontologyGWDTO.getConfig().getDefinitionProperties())
        .synonymProperties(ontologyGWDTO.getConfig().getSynonymProperties())
        .build();
  }

}
