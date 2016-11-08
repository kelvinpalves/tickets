/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.config.auth;

import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Data
public class AuthenticationCommand {
    
    private String usuario;
    private String senha;
    
}
