package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.ContaService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * ContaResource class.
 */
@Path("/conta")
@ApplicationScoped
public class ContaResource {

  @Inject
  ContaService service;

  @Inject
  TokenUtil tokenUtil;

  @GET
  @Path("/extrato")
  public List<Lancamento> getExtrato(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.getExtrato(idUsuario);
  }

  @GET
  @Path("/saldo")
  public SaldoResult getSaldo(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.getSaldo(idUsuario);
  }

}
