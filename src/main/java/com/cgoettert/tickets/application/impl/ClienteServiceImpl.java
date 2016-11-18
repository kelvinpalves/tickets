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
            getFeedback().feedMessage(MessageType.SUCCESS, "Cliente cadastrado com sucesso!");
        } catch (Exception ex) {
            getFeedback().feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void novoTelefone(final String username, final String ddd, final String numero, final String descricao) {
        try {
            Cliente cliente = clienteRepository.get(username);
            Telefone telefone = new Telefone(ddd, numero, descricao);
            cliente.getTelefones().add(telefone);
            getFeedback().feedMessage(MessageType.SUCCESS, "Telefone cadastrado com sucesso!");
        } catch (Exception ex) {
            getFeedback().feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void novoVeiculo(final String username, final String placa, final String tipo, final String descricao) {
        try {
            Cliente cliente = clienteRepository.get(username);
            Veiculo veiculo = new Veiculo(placa, descricao, true, TipoVeiculo.valueOf(tipo));
            cliente.getVeiculos().add(veiculo);
            getFeedback().feedMessage(MessageType.SUCCESS, "Veiculo cadastrado com sucesso!");
        } catch (Exception ex) {
            getFeedback().feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
        }
    }

    @Override
    @Transactional
    public void comprarCredito(final String username, final Integer valor) {
        Cliente usuario = clienteRepository.get(username);
        usuario.comprarCredito(valor);
    }

    @Override
    public Cliente getCliente(final String username) {
        try {
            Cliente cliente = clienteRepository.get(username);
            getFeedback().feedData(Cliente.class, cliente);
            return cliente;
        } catch (Exception ex) {
            getFeedback().feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public Bilhete ativarBilhete(final String username, final String placa, final Integer minutos) {
        Cliente usuario = clienteRepository.get(username);
        return usuario.ativarBilhete(placa, minutos);
    }

    @Override
    @Transactional
    public Bilhete regularizarBilhete(final String username, final String codigo) {
        Cliente usuario = clienteRepository.get(username);
        return usuario.regularizarBilhete(codigo);
    }

    @Override
    public boolean auth(final String username, final String senha) {
        try {
            clienteRepository.get(username, senha);
            getFeedback().feedMessage(MessageType.SUCCESS, "Autenticação efetuada com sucesso!");
            return true;
        } catch (Exception ex) {
            getFeedback().feedMessage(MessageType.ERROR, ex.getLocalizedMessage());
            return false;
        }
    }

}
