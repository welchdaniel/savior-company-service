package com.savior.product_service.utils.exception;

public class SaviorBaseException extends Exception {

  public SaviorBaseException(String message) {
    super(message);
    assert message != null && !message.isBlank();
  }

  public SaviorBaseException() {}
}
