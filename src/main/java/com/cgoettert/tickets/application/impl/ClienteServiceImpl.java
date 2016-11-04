/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application.impl;

import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.application.utils.MessageType;
import com.cgoettert.tickets.application.utils.ServiceSupport;
import com.cgoettert.tickets.domain.model.Bilhete;
import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.domain.model.ClienteRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class ClienteServiceImpl extends ServiceSupport implements ClienteService {

    private ClienteRepository clienteRepository;

    private ClienteServiceImpl() {
    }

    @Inject
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public void cadastrar(String nome, String cpfCnpj) {
        try {
            Cliente cliente = new Cliente(nome, cpfCnpj);
            clienteRepository.store(cliente);
            feedMessage(MessageType.SUCCESS, "Cliente cadastrado com sucesso!");
        } catch (Exception ex) {
            feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    public void comprarCredito(String cpfCnpj, Integer valor) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        usuario.comprarCredito(valor);
    }

    @Override
    public Cliente getCliente(String cpfCnpj) {
        Cliente cliente = clienteRepository.get(cpfCnpj);
        feedData(Cliente.class, cliente);
        return cliente;
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
