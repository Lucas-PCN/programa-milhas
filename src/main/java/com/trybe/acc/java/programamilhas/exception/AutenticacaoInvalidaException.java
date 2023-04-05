package com.trybe.acc.java.programamilhas.exception;

/**
 * AutenticacaoInvalidaException class.
 */
public class AutenticacaoInvalidaException extends Exception {

  private static final long serialVersionUID = 1L;

  public AutenticacaoInvalidaException() {
    super("Autenticacão inválida.");
  }

}
