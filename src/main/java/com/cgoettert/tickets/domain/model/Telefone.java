/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cgoettert
 */
@Getter
public class Telefone {
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String ddd;
    private String numero;
    private String descricao;

    private Telefone() {
    }

    public Telefone(String ddd, String numero, String descricao) {
        this.ddd = ddd;
        this.numero = numero;
        this.descricao = descricao;
    }
    
}
