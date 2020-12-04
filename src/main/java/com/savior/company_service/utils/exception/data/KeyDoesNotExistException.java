package com.savior.company_service.utils.exception.data;

import com.savior.company_service.utils.exception.SaviorBaseException;

public class KeyDoesNotExistException extends SaviorBaseException {
  public KeyDoesNotExistException() {
    super("The specified key does not exist");
  }
}
