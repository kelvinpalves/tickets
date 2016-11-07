/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.credito;

import com.cgoettert.tickets.application.ClienteService;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author cgoettert
 */
@Path("credito")
public class CreditoController {

    @Inject
    private ClienteService clienteService;

    @GET
    public Map carregar() throws Exception {
        clienteService.getCliente("01926174003");
        return clienteService.getFeedback();
    }

    @POST
    public Map comprar(@FormParam("valor") Integer valor) throws Exception {
        clienteService.comprarCredito("01926174003", valor);
        return clienteService.getFeedback();
    }

}
