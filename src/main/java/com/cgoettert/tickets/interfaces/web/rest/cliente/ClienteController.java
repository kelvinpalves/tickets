/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.cliente;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.AuthenticatedUser;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.NotSecured;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.Usuario;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
@Path("cliente")
public class ClienteController {

    @Inject
    @AuthenticatedUser
    private Usuario user;
    
    @Inject
    private ClienteService clienteService;

    @GET
    public Response buscar() throws Exception {
        clienteService.getCliente(user.getUsername());
        return Response.ok(clienteService.getFeedback()).build();
    }

    @POST
    @NotSecured
    public Response cadastrar(NovoClienteComando cliente) throws Exception {
        clienteService.novoCliente(
                cliente.getNome(),
                cliente.getCpfCnpj(),
                cliente.getEmail());
        
        return Response.ok(clienteService.getFeedback()).build();
    }

}
