/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest;

import com.cgoettert.tickets.application.ClienteService;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
@Path("bilhete")
public class BilheteController {

    @Inject
    private ClienteService clienteService;
    
    private static final Map<Integer, String> opcoes;
    static
    {
        opcoes = new HashMap<>();
        opcoes.put(15, "15min");
        opcoes.put(30, "30min");
        opcoes.put(60, "60min");
    }

    @GET
    public Response carregar() throws Exception {
        clienteService.getCliente("01926174003");
        return Response.ok(clienteService.getFeedback()).build();
    }

    @POST
    public Map comprar(@FormParam("placa") String placa, @FormParam("opcao") Integer opcao) throws Exception {

        if (!opcoes.containsKey(opcao)) {
            return null;
        }

        clienteService.ativarBilhete("01926174003", placa, opcao);
        return clienteService.getFeedback();
    }

}
