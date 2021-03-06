/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.infra.persistence.hibernate;

import com.cgoettert.tickets.domain.model.Cliente;
import com.cgoettert.tickets.domain.model.ClienteRepository;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class ClienteHibernate extends HibernateRepository implements ClienteRepository {

    @Override
    public Cliente get(final String cpfCnpj) {
        return (Cliente) getEm()
                .createQuery("select c from Cliente c where c.cpfCnpj = :cpfCnpj")
                .setParameter("cpfCnpj", cpfCnpj)
                .getSingleResult();
    }

    @Override
    public void get(final String cpfCnpj, final String senha) {
        getEm().createQuery("select c.cpfCnpj from Cliente c where c.cpfCnpj = :cpfCnpj and c.senha = :senha")
                .setParameter("cpfCnpj", cpfCnpj)
                .setParameter("senha", senha)
                .getSingleResult();
    }

    @Override
    public void store(final Cliente usuario) {
        getEm().persist(usuario);
    }

}
