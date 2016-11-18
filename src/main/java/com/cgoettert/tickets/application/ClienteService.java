/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application;

import com.cgoettert.tickets.application.utils.Feed;
import com.cgoettert.tickets.domain.model.Bilhete;
import com.cgoettert.tickets.domain.model.Cliente;

/**
 *
 * @author cgoettert
 */
public interface ClienteService extends Feed {
    
    public void novoCliente(String nome, String cpfCnpj, String email);
    
    public void novoTelefone(String username, String ddd, String numero, String descricao);
    
    public void novoVeiculo(String username, String placa, String tipo, String descricao);
            
    public void comprarCredito(String username, Integer valor);
    
    public Cliente getCliente(String username);
    
    public Bilhete ativarBilhete(String username, String placa, Integer minutos);
    
    public Bilhete regularizarBilhete(String username, String codigo);
    
    public boolean auth(String username, String senha);
        
}
