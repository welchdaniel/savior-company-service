package com.savior.company_service.utils.exception.service;

import com.savior.company_service.utils.exception.SaviorBaseException;

public class CompanyDoesNotExistException extends SaviorBaseException {
  public CompanyDoesNotExistException() {
    super("The specified company does not exist");
  }
}
