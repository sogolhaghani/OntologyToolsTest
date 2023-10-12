package ebi.ac.uk.ontologytoolstest.service;

import ebi.ac.uk.ontologytoolstest.exception.NotFoundException;
import ebi.ac.uk.ontologytoolstest.model.OntologyModel;

public interface IOntologyService {

  OntologyModel findById(String ontologyId) throws NotFoundException;

}
