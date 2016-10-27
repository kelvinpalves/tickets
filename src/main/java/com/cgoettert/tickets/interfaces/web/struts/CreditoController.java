/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.struts;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
import com.opensymphony.xwork2.ActionSupport;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author cgoettert
 */
@Namespace("/credito")
@Results({
    @Result(name = "error", location = "../error.jsp"),
    @Result(name = "input", location = "../input.jsp")
})
public class CreditoController extends ActionSupport {

    @Inject
    private ClienteService clienteService;

    @Getter
    private Cliente cliente;
    @Getter
    private String message;
    @Getter
    @Setter
    private Integer valor;

    @Action(value = "carregar")
    public String carregar() throws Exception {
        message = "Comprar Crédito";
        cliente = clienteService.getCliente("01926174003");
        return SUCCESS;
    }

    @Action(value = "comprar", results = {
        @Result(name = "success", location = "carregar", type = "redirectAction")
    })
    public String comprar() throws Exception {
        clienteService.comprarCredito("01926174003", valor);
        return SUCCESS;
    }

}
