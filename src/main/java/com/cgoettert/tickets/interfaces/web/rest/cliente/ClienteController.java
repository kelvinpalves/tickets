/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.cliente;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
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
    private ClienteService clienteService;

    @GET
    public Response buscar() throws Exception {
        Cliente c = clienteService.getCliente("01926174003");
        return Response.ok(clienteService.getFeedback()).build();
    }

    @POST
    public Response cadastrar(NovoClienteComando cliente) throws Exception {
        clienteService.novoCliente(
                cliente.getNome(),
                cliente.getCpfCnpj(),
                cliente.getEmail());
        
        return Response.ok(clienteService.getFeedback()).build();
    }

}
