package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * ContaService class.
 */
@ApplicationScoped
public class ContaService {

  @Inject
  ContaDao contaDao;

  public List<Lancamento> getExtrato(Integer idUsuario) {
    return contaDao.getExtrato(idUsuario);
  }

  public SaldoResult getSaldo(Integer idUsuario) {
    return contaDao.getSaldo(idUsuario);
  }

}
