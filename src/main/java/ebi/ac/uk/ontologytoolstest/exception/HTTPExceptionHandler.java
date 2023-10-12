package ebi.ac.uk.ontologytoolstest.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpRetryException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.client.HttpStatusCodeException;

public class HTTPExceptionHandler {

  private static final String TIMESTAMP = "timestamp";
  private static final String EXCEPTION = "exception";
  private static final String MESSAGE = "message";
  private static final String STATUS = "status";
  private static final String PATH = "path";

  public static HttpStatusCode getExceptionCode(Exception ex) {
    if (ex instanceof NotFoundException) {
      return HttpStatus.NOT_FOUND;
    }
    if (ex instanceof HttpMessageConversionException) {
      return HttpStatus.UNPROCESSABLE_ENTITY;
    }
    if (ex instanceof HttpMediaTypeNotSupportedException
        || ex instanceof HttpMediaTypeNotAcceptableException) {
      return HttpStatus.UNSUPPORTED_MEDIA_TYPE;
    }
    if (ex instanceof HttpRequestMethodNotSupportedException) {
      return HttpStatus.METHOD_NOT_ALLOWED;
    }
    if (ex instanceof HttpRetryException) {
      return HttpStatus.valueOf(((HttpRetryException) ex).responseCode());
    }
    if (ex instanceof HttpSessionRequiredException) {
      return HttpStatus.REQUEST_TIMEOUT;
    }
    if (ex instanceof HttpStatusCodeException) {
      return ((HttpStatusCodeException) ex).getStatusCode();
    }
    if (ex instanceof RuntimeException) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    if (ex instanceof GeneralSecurityException) {
      return HttpStatus.UNAUTHORIZED;
    }

    if (ex instanceof TimeoutException) {
      return HttpStatus.GATEWAY_TIMEOUT;
    }
    if (ex instanceof ReflectiveOperationException) {
      return HttpStatus.NOT_ACCEPTABLE;
    }
    if (ex instanceof IOException) {
      return HttpStatus.UNSUPPORTED_MEDIA_TYPE;
    }
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

  public static Map<String, Object> getExceptionAttributes(Exception exception,
      HttpServletRequest httpRequest,
      HttpStatusCode httpStatus) {

    Map<String, Object> exceptionAttributes = new LinkedHashMap<>();

    exceptionAttributes.put(TIMESTAMP, new Date());
    exceptionAttributes.put(STATUS, httpStatus.value());
    exceptionAttributes.put(EXCEPTION, exception.getClass().getName());
    exceptionAttributes.put(MESSAGE, exception.getMessage());
    exceptionAttributes.put(PATH, httpRequest.getServletPath());

    return exceptionAttributes;
  }

}
