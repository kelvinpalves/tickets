/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.infra.persistence.inmemory;

import com.cgoettert.tickets.domain.model.Usuario;
import com.cgoettert.tickets.domain.model.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cgoettert
 */
public class UsuarioDAO implements UsuarioRepository {

    private static final Map<String, Usuario> USUARIOS = new HashMap<>();
    
    @Override
    public Usuario get(String cpfCnpj) {
        return USUARIOS.get(cpfCnpj);
    }

    @Override
    public void store(Usuario usuario) {
        USUARIOS.put(usuario.getCpfCnpj(), usuario);
    }
    
}
