/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.telefone;

import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Data
public class NovoTelefoneComando {

    private String ddd;
    private String numero;
    private String descricao;

}
