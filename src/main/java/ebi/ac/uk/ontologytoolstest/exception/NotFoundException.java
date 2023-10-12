package ebi.ac.uk.ontologytoolstest.exception;

import org.slf4j.helpers.MessageFormatter;

public class NotFoundException extends RuntimeException{

  private String message;
  public NotFoundException(String message, Object... var2) {
    this.message = MessageFormatter.arrayFormat(message, var2).getMessage();
  }

  @Override
  public String getMessage() {
    if(this.message != null)
      return this.message;
    return super.getMessage();
  }
}
