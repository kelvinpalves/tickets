/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.telefone;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.AuthenticatedUser;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.User;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
@Path("telefone")
public class TelefoneController {

    @Inject
    @AuthenticatedUser
    private User user;

    @Inject
    private ClienteService clienteService;

    @GET
    public Response buscar() throws Exception {
        clienteService.getCliente(user.getUsername());
        return Response.ok(clienteService.getFeedback()).build();
    }

    @POST
    public Response cadastrar(NovoTelefoneComando telefone) throws Exception {
        clienteService.novoTelefone(
                user.getUsername(),
                telefone.getDdd(),
                telefone.getNumero(),
                telefone.getDescricao());
        return Response.ok(clienteService.getFeedback()).build();
    }

}
