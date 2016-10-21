/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

/**
 *
 * @author cgoettert
 */
public interface UsuarioRepository {
    
    Usuario get(String cpfCnpj);
    
    void store(Usuario usuario);
    
}
