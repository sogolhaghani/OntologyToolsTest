package ebi.ac.uk.ontologytoolstest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@EnableMongoRepositories
public class OntologyControllerIT {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext applicationContext;

  @BeforeEach
  public void init() {
    this.mockMvc = MockMvcBuilders
        .webAppContextSetup(applicationContext)
        .build();
  }

  @Test
  public void givenOntology_withValidID_thenStatus200() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/ontology/efo").secure(true)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }


  @Test
  public void givenOntology_withInValidID_thenStatus404() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/ontology/sogol").secure(true)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }

}
