/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application;

import com.cgoettert.tickets.application.utils.Feedback;
import com.cgoettert.tickets.domain.model.Bilhete;
import com.cgoettert.tickets.domain.model.Cliente;

/**
 *
 * @author cgoettert
 */
public interface ClienteService extends Feedback {
    
    public void novoCliente(String nome, String cpfCnpj, String email);
    
    public void novoTelefone(String cpfCnpj, String ddd, String numero, String descricao);
    
    public void novoVeiculo(String cpfCnpj, String placa, String tipo, String descricao);
            
    public void comprarCredito(String cpfCnpj, Integer valor);
    
    public Cliente getCliente(String cpfCnpj);
    
    public Bilhete ativarBilhete(String cpfCnpj, String placa, Integer minutos);
    
    public Bilhete regularizarBilhete(String cpfCnpj, String codigo);
        
}
