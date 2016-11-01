package com.cgoettert.tickets.infra.persistence.hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cgoettert
 */
public abstract class HibernateRepository {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

}
