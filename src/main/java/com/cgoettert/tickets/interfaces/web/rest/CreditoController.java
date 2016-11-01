/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cgoettert
 */
@Path("credito")
public class CreditoController {

    @Inject
    private ClienteService clienteService;

    @Getter
    private Cliente cliente;
    @Getter
    private String message;
    @Getter
    @Setter
    private Integer valor;

    @GET
    public String carregar() throws Exception {
        message = "Comprar Crédito";
        cliente = clienteService.getCliente("01926174003");
        return "";
    }

    @POST
    public String comprar() throws Exception {
        clienteService.comprarCredito("01926174003", valor);
        return "";
    }

}
