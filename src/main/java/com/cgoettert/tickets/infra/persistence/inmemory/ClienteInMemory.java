/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.infra.persistence.inmemory;

import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.domain.model.ClienteRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class ClienteInMemory implements ClienteRepository {

    private static final Map<String, Cliente> USUARIOS;
    static {
        Map<String, Cliente> aMap = new HashMap<>();
        aMap.put("01926174003", new Cliente("Charles Goettert", "01926174003"));
        USUARIOS = Collections.unmodifiableMap(aMap);
    }
    
    @Override
    public Cliente get(String cpfCnpj) {
        return USUARIOS.get(cpfCnpj);
    }

    @Override
    public void store(Cliente usuario) {
        USUARIOS.put(usuario.getCpfCnpj(), usuario);
    }
    
}
