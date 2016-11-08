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
public interface ClienteRepository {
    
    public Cliente get(String cpfCnpj);
    
    public void get(String cpfCnpj, String senha);
    
    public void store(Cliente usuario);
    
}
