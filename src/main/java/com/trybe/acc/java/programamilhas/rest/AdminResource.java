package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.AdminService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * AdminResource class.
 */
@Path("/admin")
@ApplicationScoped
public class AdminResource {

  @Inject
  AdminService service;

  @Inject
  TokenUtil tokenUtil;

  @POST
  @Path("/credito")
  public MensagemResult depositarComoAdmin(@QueryParam("token") String tk, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(tk);
    return service.depositarComoAdmin(lancamento);
  }

  @POST
  @Path("/resgate")
  public MensagemResult sacarComoAdmin(@QueryParam("token") String token, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return service.sacarComoAdmin(lancamento);
  }

  @POST
  @Path("/saldos")
  public List<SaldoResult> getSaldos(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return service.getSaldos();
  }

}
