/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Cliente;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
@Path("bilhete")
public class BilheteController {

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

    @GET
    public Map carregar() throws Exception {
        message = "Ativar Bilhete";
        cliente = clienteService.getCliente("01926174003");
        Map retorno = clienteService.getFeedback();
        retorno.put("data", cliente);
        return retorno;
    }

    @POST
    public String comprar() throws Exception {

        if (!opcoes.contains(opcao)) {
            return "";
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
        return "";
    }

}
