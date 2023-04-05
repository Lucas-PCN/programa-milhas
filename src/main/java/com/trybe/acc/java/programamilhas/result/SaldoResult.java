package com.trybe.acc.java.programamilhas.result;

/**
 * SaldoResult class.
 */
public class SaldoResult {

  private Integer idUsuario;
  private String login;
  private Integer saldo;

  /**
   * Constructor.
   */
  public SaldoResult(Integer idUsuario, String login, Integer saldo) {
    this.idUsuario = idUsuario;
    this.login = login;
    this.saldo = saldo;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Integer getSaldo() {
    return saldo;
  }

  public void setSaldo(Integer saldo) {
    this.saldo = saldo;
  }

}
