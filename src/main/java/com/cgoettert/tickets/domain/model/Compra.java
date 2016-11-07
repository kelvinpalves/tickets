/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author cgoettert
 */
@Getter
public class Compra {
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String codigo;
    private BigDecimal valor;
    private Date dataRegistro;
    private Boolean cancelada;

    private Compra() {
    }

    public Compra(BigDecimal valor) {
        this.valor = valor;
        this.codigo = RandomStringUtils.random(10);
        this.dataRegistro = new Date();
        cancelada = false;
    }    
    
}
