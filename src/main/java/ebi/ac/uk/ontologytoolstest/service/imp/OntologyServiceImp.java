package ebi.ac.uk.ontologytoolstest.service.imp;

import ebi.ac.uk.ontologytoolstest.exception.NotFoundException;
import ebi.ac.uk.ontologytoolstest.gateway.dto.OntologyDTO;
import ebi.ac.uk.ontologytoolstest.gateway.OntologyLookupServiceGateway;
import ebi.ac.uk.ontologytoolstest.model.OntologyModel;
import ebi.ac.uk.ontologytoolstest.repository.OntologyRepository;
import ebi.ac.uk.ontologytoolstest.service.IOntologyService;
import ebi.ac.uk.ontologytoolstest.service.mapper.OntologyMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class OntologyServiceImp implements IOntologyService {

  private final OntologyRepository repository;
  private final OntologyMapper ontologyMapper;
  private final OntologyLookupServiceGateway ontologyLookupServiceGateway;

  @Override
  public OntologyModel findById(String ontologyId) throws NotFoundException {
    Optional<OntologyModel> byId = repository.findById(ontologyId);
    if(byId.isPresent()){
      return byId.get();
    }
    Optional<OntologyDTO> ontologyGWDTO = ontologyLookupServiceGateway.fetchByOntologyId(ontologyId);
    if(ontologyGWDTO.isEmpty()){
      throw new NotFoundException("Ontology with id {} is not found on LookupService",ontologyId);
    }
    OntologyModel model = ontologyMapper.mapToModel(ontologyGWDTO.get()); // TODO : model to dto for client
    return repository.insert(model);
  }
}
