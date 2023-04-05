package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.TransacaoDao;
import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.SaldoInsuficienteException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import java.time.LocalDate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * TransacaoService class.
 */
@ApplicationScoped
public class TransacaoService {

  @Inject
  TransacaoDao transacaoDao;

  /**
   * resgateProduto method.
   */
  public MensagemResult resgateProduto(Integer idUsuario, ResgateProdutoDto resgate)
      throws SaldoInsuficienteException {
    Integer saldo = transacaoDao.getSaldoUsuario(idUsuario);

    Produto produto = transacaoDao.getProduto(resgate.getIdProduto());

    if (saldo < produto.getValor()) {
      throw new SaldoInsuficienteException();
    }

    Pessoa usuario = transacaoDao.getUsuarioById(idUsuario);

    TipoLancamento tipoLancamento = new TipoLancamento();
    tipoLancamento.setId(4);
    tipoLancamento.setDescricao("Débito");

    Lancamento lancamento = new Lancamento();
    lancamento.setUsuario(usuario);
    lancamento.setProduto(produto);
    lancamento.setTipoLancamento(tipoLancamento);
    lancamento.setValor(produto.getValor() * -1);
    lancamento.setDescricao("Resgate de produto");
    lancamento.setData(LocalDate.now());

    transacaoDao.sacarComoUsuario(lancamento);
    return new MensagemResult("Resgate efetuado com sucesso!");
  }

  /**
   * Transaferencia method.
   */
  @Transactional
  public MensagemResult transferencia(Integer idUsuario, TransferenciaDto transferencia)
      throws SaldoInsuficienteException {
    Integer saldoUsuario = transacaoDao.getSaldoUsuario(idUsuario);

    if (saldoUsuario < transferencia.getValor()) {
      throw new SaldoInsuficienteException();
    }

    Pessoa usuario = transacaoDao.getUsuarioById(idUsuario);
    TipoLancamento debito = new TipoLancamento();
    debito.setId(2);
    debito.setDescricao("Débito");

    Lancamento lancamentoDebito = new Lancamento();
    lancamentoDebito.setUsuario(usuario);
    lancamentoDebito.setTipoLancamento(debito);
    lancamentoDebito.setValor(transferencia.getValor() * -1);
    lancamentoDebito.setDescricao("Transferência de pontos");
    lancamentoDebito.setData(LocalDate.now());
    transacaoDao.sacarComoUsuario(lancamentoDebito);

    Pessoa usuarioDestino = transacaoDao.getUsuarioByNome(transferencia.getUsuarioDestino());
    TipoLancamento credito = new TipoLancamento();
    credito.setId(2);
    credito.setDescricao("Crédito");

    Lancamento lancamentoCredito = new Lancamento();
    lancamentoCredito.setUsuario(usuarioDestino);
    lancamentoCredito.setTipoLancamento(credito);
    lancamentoCredito.setValor(transferencia.getValor());
    lancamentoCredito.setDescricao("Transferência de pontos");
    lancamentoCredito.setData(LocalDate.now());
    transacaoDao.depositarComoUsuario(lancamentoCredito);

    return new MensagemResult("Transferência efetuada com sucesso!");
  }

}
