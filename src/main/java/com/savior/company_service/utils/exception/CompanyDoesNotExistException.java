package com.savior.company_service.utils.exception;

public class CompanyDoesNotExistException extends SaviorBaseException {
  public CompanyDoesNotExistException() {
    super("The specified key does not exist");
  }
}
