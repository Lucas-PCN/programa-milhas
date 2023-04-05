package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.AdminDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * AdminService class.
 */
@ApplicationScoped
public class AdminService {

  @Inject
  AdminDao adminDao;

  @Inject
  PessoaDao pessoaDao;

  @Inject
  LancamentoUtil lancamentoUtil;

  /**
   * depositarComoAdmin method.
   */
  public MensagemResult depositarComoAdmin(LancamentoDto lancamentoDto) {
    Pessoa pessoa = pessoaDao.getPessoaByNome(lancamentoDto.getUsuario());

    Lancamento lancamento = lancamentoUtil.criarLancamento(
        pessoa.getId(),
        lancamentoDto.getValor(),
        lancamentoDto.getIdTipoLancamento(),
        lancamentoDto.getIdParceiro(),
        lancamentoDto.getDescricao(),
        null
    );

    adminDao.depositarComoAdmin(lancamento);

    return new MensagemResult("Crédito adicionado com sucesso!");
  }

  /**
   * sacarComoAdmin method.
   */
  public MensagemResult sacarComoAdmin(LancamentoDto lancamentoDto) {
    Pessoa pessoa = pessoaDao.getPessoaByNome(lancamentoDto.getUsuario());

    TipoLancamento tipoLancamento = new TipoLancamento();
    tipoLancamento.setId(lancamentoDto.getIdTipoLancamento());
    tipoLancamento.setDescricao(lancamentoDto.getDescricao());

    Lancamento lancamento = new Lancamento();
    lancamento.setUsuario(pessoa);
    lancamento.setTipoLancamento(tipoLancamento);
    lancamento.setValor(lancamentoDto.getValor() * -1);
    lancamento.setDescricao(lancamentoDto.getDescricao());
    lancamento.setData(LocalDate.now());

    adminDao.sacarComoAdmin(lancamento);

    return new MensagemResult("Resgate efetuado com sucesso!");
  }

  /**
   * getSaldos method.
   */
  public List<SaldoResult> getSaldos() {
    return adminDao.getSaldos();
  }

}