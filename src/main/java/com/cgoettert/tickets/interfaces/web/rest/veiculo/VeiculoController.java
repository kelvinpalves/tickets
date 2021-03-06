/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.veiculo;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.TipoVeiculo;
import com.cgoettert.tickets.interfaces.web.rest.ControllerSupport;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.AuthenticatedUser;
import com.cgoettert.tickets.interfaces.web.rest.config.auth.User;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
@Path("veiculo")
public class VeiculoController extends ControllerSupport {

    @Inject
    @AuthenticatedUser
    private User user;

    @Inject
    private ClienteService clienteService;

    @GET
    public Response buscar() throws Exception {
        clienteService.getCliente(user.getUsername());
        Map ret = clienteService.getFeed();
        ret.put("tipos", TipoVeiculo.values());
        return Response.ok(ret).build();
    }

    @POST
    public Response cadastrar(NovoVeiculoComando veiculo) throws Exception {
        clienteService.novoVeiculo(
                user.getUsername(),
                veiculo.getPlaca(),
                veiculo.getTipo(),
                veiculo.getDescricao());
        return Response.ok(clienteService.getFeed()).build();
    }

}
