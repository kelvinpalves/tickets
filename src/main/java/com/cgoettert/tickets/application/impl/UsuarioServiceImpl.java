/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application.impl;

import com.cgoettert.tickets.application.UsuarioService;
import com.cgoettert.tickets.domain.model.Bilhete;
import com.cgoettert.tickets.domain.model.Usuario;
import com.cgoettert.tickets.domain.model.UsuarioRepository;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    
    private UsuarioServiceImpl() {
    }

    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
        
    @Override
    public void comprarCredito(String cpfCnpj, Integer valor) {
        Usuario usuario = usuarioRepository.get(cpfCnpj);
        usuario.comprarCredito(valor);
    }

    @Override
    public BigDecimal getSaldo(String cpfCnpj) {
        Usuario usuario = usuarioRepository.get(cpfCnpj);
        return usuario.getSaldo();
    }

    @Override
    public Bilhete ativarBilhete(String cpfCnpj, String placa, Integer minutos) {
        Usuario usuario = usuarioRepository.get(cpfCnpj);
        return usuario.ativarBilhete(placa, minutos);
    }

    @Override
    public Bilhete regularizarBilhete(String cpfCnpj, String codigo) {
        Usuario usuario = usuarioRepository.get(cpfCnpj);
        return usuario.regularizarBilhete(codigo);
    }
    
}
