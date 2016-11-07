/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.veiculo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cgoettert
 */
@Getter
@Setter
public class NovoVeiculoComando {

    private String placa;
    private String tipo;
    private String descricao;
    private Boolean debito;

}
