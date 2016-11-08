/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.cliente;

import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Data
public class NovoClienteComando {
    
    private String nome;
    private String cpfCnpj;
    private String email;
    private String senha;
    
}
