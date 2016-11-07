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
import com.cgoettert.tickets.domain.model.Telefone;
import com.cgoettert.tickets.domain.model.TipoVeiculo;
import com.cgoettert.tickets.domain.model.Veiculo;
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
    public void novoCliente(final String nome, final String cpfCnpj, final String email) {
        try {
            Cliente cliente = new Cliente(nome, cpfCnpj, email);
            clienteRepository.store(cliente);
            feedMessage(MessageType.SUCCESS, "Cliente cadastrado com sucesso!");
        } catch (Exception ex) {
            feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void novoTelefone(final String cpfCnpj, final String ddd, final String numero, final String descricao) {
        try {
            Cliente cliente = clienteRepository.get(cpfCnpj);
            Telefone telefone = new Telefone(ddd, numero, descricao);
            cliente.getTelefones().add(telefone);
            feedMessage(MessageType.SUCCESS, "Telefone cadastrado com sucesso!");
        } catch (Exception ex) {
            feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void novoVeiculo(final String cpfCnpj, final String placa, final String tipo, final String descricao) {
        try {
            Cliente cliente = clienteRepository.get(cpfCnpj);
            Veiculo veiculo = new Veiculo(placa, descricao, true, TipoVeiculo.valueOf(tipo));
            cliente.getVeiculos().add(veiculo);
            feedMessage(MessageType.SUCCESS, "Veiculo cadastrado com sucesso!");
        } catch (Exception ex) {
            feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void comprarCredito(final String cpfCnpj, final Integer valor) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        usuario.comprarCredito(valor);
    }

    @Override
    public Cliente getCliente(final String cpfCnpj) {
        Cliente cliente = clienteRepository.get(cpfCnpj);
        feedData(Cliente.class, cliente);
        return cliente;
    }

    @Override
    @Transactional
    public Bilhete ativarBilhete(final String cpfCnpj, final String placa, final Integer minutos) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        return usuario.ativarBilhete(placa, minutos);
    }

    @Override
    @Transactional
    public Bilhete regularizarBilhete(final String cpfCnpj, final String codigo) {
        Cliente usuario = clienteRepository.get(cpfCnpj);
        return usuario.regularizarBilhete(codigo);
    }

}
