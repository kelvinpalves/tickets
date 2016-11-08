/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.config.auth;

import lombok.Getter;

/**
 *
 * @author cgoettert
 */
@Getter
public class Usuario {

    private String username;

    public Usuario() {
        this.username = "";
    }

    public Usuario(String username) {
        this.username = username;
    }

}
