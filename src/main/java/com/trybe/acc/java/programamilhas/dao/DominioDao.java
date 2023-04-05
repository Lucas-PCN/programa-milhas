package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * DominioDao class.
 */
@ApplicationScoped
public class DominioDao {

  @Inject
  EntityManager entityManager;

  public List<Parceiro> getParceiros() {
    String hql = "SELECT p FROM Parceiro p";
    return entityManager.createQuery(hql, Parceiro.class).getResultList();
  }

  public List<Produto> getProdutos() {
    String hql = "SELECT p FROM Produto p";
    return entityManager.createQuery(hql, Produto.class).getResultList();
  }

  public List<TipoLancamento> getTiposLancamento() {
    String hql = "SELECT t FROM TipoLancamento t";
    return entityManager.createQuery(hql, TipoLancamento.class).getResultList();
  }

}
