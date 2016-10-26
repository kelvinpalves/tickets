/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application.impl;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.domain.model.Bilhete;
import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.domain.model.ClienteRepository;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    
    private ClienteServiceImpl() {
    }

    @Inject
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
        
    @Override
    public void comprarCredito(String cpfCnpj, Integer valor) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        usuario.comprarCredito(valor);
    }

    @Override
    public Cliente getCliente(String cpfCnpj) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        return usuario;
    }

    @Override
    public Bilhete ativarBilhete(String cpfCnpj, String placa, Integer minutos) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        return usuario.ativarBilhete(placa, minutos);
    }

    @Override
    public Bilhete regularizarBilhete(String cpfCnpj, String codigo) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        return usuario.regularizarBilhete(codigo);
    }
    
}
