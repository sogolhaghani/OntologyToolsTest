package ebi.ac.uk.ontologytoolstest.gateway.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LinkDTO implements Serializable {

  private LinkItemDTO self;
  private LinkItemDTO terms;
  private LinkItemDTO properties;
  private LinkItemDTO individuals;

  @Data
  @AllArgsConstructor
  @RequiredArgsConstructor
  class LinkItemDTO {
    private String href;
  }
}
