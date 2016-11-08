/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author cgoettert
 */
@javax.ws.rs.ApplicationPath("rs")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.cgoettert.tickets.interfaces.web.rest.bilhete.BilheteController.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.cliente.ClienteController.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.config.CrossOriginResourceSharingFilter.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.config.auth.AuthenticationController.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.config.auth.AuthenticationFilter.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.credito.CreditoController.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.telefone.TelefoneController.class);
        resources.add(com.cgoettert.tickets.interfaces.web.rest.veiculo.VeiculoController.class);
    }
    
}
