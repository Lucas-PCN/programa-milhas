package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.exception.SaldoInsuficienteException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.TransacaoService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * TransacaoResource class.
 */
@Path("/transacao")
@ApplicationScoped
public class TransacaoResource {

  @Inject
  TransacaoService service;

  @Inject
  TokenUtil tokenUtil;

  @POST
  @Path("/resgate-produto")
  public MensagemResult resgateProduto(
      @QueryParam("token") String token, ResgateProdutoDto resgate
  ) throws AcessoNaoAutorizadoException, SaldoInsuficienteException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.resgateProduto(idUsuario, resgate);
  }

  @POST
  @Path("/transferencia")
  public MensagemResult transferencia(
      @QueryParam("token") String token, TransferenciaDto transferencia
  ) throws AcessoNaoAutorizadoException, SaldoInsuficienteException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.transferencia(idUsuario, transferencia);
  }

}
