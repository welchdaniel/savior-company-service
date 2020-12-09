package com.savior.product_service.utils.exception.service;

import com.savior.product_service.utils.exception.SaviorBaseException;

public class CompanyDoesNotExistException extends SaviorBaseException {
  public CompanyDoesNotExistException() {
    super("The specified company does not exist");
  }
}
