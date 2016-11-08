/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.config.auth;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class AuthenticationUserProducer {

    @Produces
    @RequestScoped
    @AuthenticatedUser
    private Usuario authenticatedUser = new Usuario();

    public void handleAuthenticationEvent(@Observes @AuthenticatedUser String username) {
        this.authenticatedUser = new Usuario(username);
    }
    
}
