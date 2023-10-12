package ebi.ac.uk.ontologytoolstest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

  private final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

  @Bean
  public RestTemplate restTemplate() {
    return restTemplateBuilder.build();
  }
}
