package ebi.ac.uk.ontologytoolstest.controller;

import ebi.ac.uk.ontologytoolstest.exception.HTTPExceptionHandler;
import ebi.ac.uk.ontologytoolstest.model.OntologyModel;
import ebi.ac.uk.ontologytoolstest.service.IOntologyService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/api/ontology")
public class OntologyController {

  private final IOntologyService service;

  @GetMapping("/{ontologyId}")
  public ResponseEntity<OntologyModel> findById(@PathVariable String ontologyId) {
    return ResponseEntity.ok(service.findById(ontologyId));
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleException(Exception exception, HttpServletRequest request) {
    HttpStatusCode status = HTTPExceptionHandler.getExceptionCode(exception);
    log.error("Exception : {}", exception.getMessage(), exception);
    Map<String, Object> responseBody = HTTPExceptionHandler.getExceptionAttributes(exception, request, status);
    return new ResponseEntity<>(responseBody, status);
  }

}
