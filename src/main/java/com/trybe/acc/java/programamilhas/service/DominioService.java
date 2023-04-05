package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.DominioDao;
import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * DominioService class.
 */
@ApplicationScoped
public class DominioService {

  @Inject
  DominioDao dominioDao;

  public List<Parceiro> getParceiros() {
    return dominioDao.getParceiros();
  }

  public List<Produto> getProdutos() {
    return dominioDao.getProdutos();
  }

  public List<TipoLancamento> getTiposLancamento() {
    return dominioDao.getTiposLancamento();
  }

}
