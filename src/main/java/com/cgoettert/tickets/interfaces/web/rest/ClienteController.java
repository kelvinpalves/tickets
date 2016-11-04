/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest;

import com.cgoettert.tickets.application.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
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

    @POST
    public Response cadastrar(@FormParam("nome") String nome, @FormParam("cpfCnpj") String cpfCnpj) throws Exception {
        clienteService.cadastrar(nome, cpfCnpj);
        return Response.ok(clienteService.getFeedback()).build();
    }

}
