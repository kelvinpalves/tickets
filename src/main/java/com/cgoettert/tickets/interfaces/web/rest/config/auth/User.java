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
public class User {

    private String username;

    public User() {
        this.username = "";
    }

    public User(String username) {
        this.username = username;
    }

}
