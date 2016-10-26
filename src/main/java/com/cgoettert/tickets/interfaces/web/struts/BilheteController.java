/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.struts;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.List;
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
@Namespace("/bilhete")
@Results({
    @Result(name = "error", location = "error.jsp"),
    @Result(name = "input", location = "input.jsp")
})
public class BilheteController extends ActionSupport {

    @Inject
    private ClienteService clienteService;

    @Getter
    private Cliente cliente;
    @Getter
    private String message;
    @Getter
    @Setter
    private String placa;
    @Getter
    @Setter
    private String opcao;
    @Getter
    private final List<String> opcoes = Arrays.asList("30min.", "1 hora.", "1 hora e meia.");

    @Action(value = "carregar")
    public String carregar() throws Exception {
        message = "Ativar Bilhete";
        cliente = clienteService.getCliente("01926174003");
        return SUCCESS;
    }

    @Action(value = "ativar", results = {
        @Result(name = "success", location = "carregar", type = "redirectAction")
    })
    public String comprar() throws Exception {

        if (!opcoes.contains(opcao)) {
            return ERROR;
        }

        Integer tempo;

        switch (opcao.length()) {
            case 6:
                tempo = 30;
                break;
            case 7:
                tempo = 60;
                break;
            default:
                tempo = 90;
                break;
        }

        clienteService.ativarBilhete("01926174003", placa, tempo);
        return SUCCESS;
    }

}
