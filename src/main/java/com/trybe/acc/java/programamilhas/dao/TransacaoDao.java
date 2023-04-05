package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.model.Produto;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * TransacaoDao class.
 */
@ApplicationScoped
public class TransacaoDao {

  @Inject
  EntityManager entityManager;

  /**
   * getSaldoUsuario method.
   */
  public Integer getSaldoUsuario(Integer idUsuario) {
    String hql = "SELECT SUM(l.valor) "
        + "FROM Lancamento l WHERE l.usuario.id = :idUsuario";

    Long result =  entityManager.createQuery(hql, Long.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();

    return result.intValue();
  }

  /**
   * getUsuarioByNome method.
   */
  public Pessoa getUsuarioByNome(String login) {
    String hql = "SELECT p FROM Pessoa p WHERE p.login = :login";

    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("login", login)
        .getSingleResult();
  }

  /**
   * getUsuarioById method.
   */
  public Pessoa getUsuarioById(Integer idUsuario) {
    String hql = "SELECT p FROM Pessoa p WHERE p.id = :idUsuario";

    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();
  }

  /**
   * getProduto method.
   */
  public Produto getProduto(Integer idProduto) {
    String hql = "SELECT p FROM Produto p WHERE p.id = :idProduto";

    return entityManager.createQuery(hql, Produto.class)
        .setParameter("idProduto", idProduto)
        .getSingleResult();
  }
  
  /**
   * depositarComoUsuario method.
   */
  @Transactional
  public void depositarComoUsuario(Lancamento lancamento) {
    entityManager.persist(lancamento);
    return;
  }

  /**
   * sacarComoUsuario method.
   */
  @Transactional
  public void sacarComoUsuario(Lancamento lancamento) {
    entityManager.persist(lancamento);
    return;
  }
}