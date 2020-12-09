package com.savior.product_service.utils.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InternalServerErrorException extends ResponseStatusException {
  public InternalServerErrorException() {
    super(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public InternalServerErrorException(String reason) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
  }

  public InternalServerErrorException(String reason, Throwable cause) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause);
  }

}
