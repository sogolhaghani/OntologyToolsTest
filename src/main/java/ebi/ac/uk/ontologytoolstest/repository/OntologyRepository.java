package ebi.ac.uk.ontologytoolstest.repository;

import ebi.ac.uk.ontologytoolstest.model.OntologyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OntologyRepository extends MongoRepository<OntologyModel, String> {

}
