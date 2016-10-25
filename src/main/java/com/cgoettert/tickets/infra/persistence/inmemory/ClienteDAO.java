/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.infra.persistence.inmemory;

import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.domain.model.ClienteRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cgoettert
 */
public class ClienteDAO implements ClienteRepository {

    private static final Map<String, Cliente> USUARIOS = new HashMap<>();
    
    @Override
    public Cliente get(String cpfCnpj) {
        return USUARIOS.get(cpfCnpj);
    }

    @Override
    public void store(Cliente usuario) {
        USUARIOS.put(usuario.getCpfCnpj(), usuario);
    }
    
}
