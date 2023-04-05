package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.PessoaService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * PessoaResource class.
 */
@Path("/pessoa")
@ApplicationScoped
public class PessoaResource {

  @Inject
  PessoaService service;

  @POST
  public MensagemResult salvar(LoginDto login)
      throws InvalidKeySpecException, NoSuchAlgorithmException  {
    return service.salvar(login);
  }

  @DELETE
  public MensagemResult deletar(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    return service.deletar(token);
  }

}
