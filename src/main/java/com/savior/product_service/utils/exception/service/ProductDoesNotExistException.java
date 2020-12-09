package com.savior.product_service.utils.exception.service;

import com.savior.product_service.utils.exception.SaviorBaseException;

public class ProductDoesNotExistException extends SaviorBaseException {
  public ProductDoesNotExistException() {
    super("The specified product does not exist");
  }
}
