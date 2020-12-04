package com.savior.company_service.utils.exception.service;

import com.savior.company_service.utils.exception.SaviorBaseException;

public class ProductDoesNotExistException extends SaviorBaseException {
  public ProductDoesNotExistException() {
    super("The specified product does not exist");
  }
}
