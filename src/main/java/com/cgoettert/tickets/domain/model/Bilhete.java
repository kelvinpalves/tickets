/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author cgoettert
 */
@Getter
public class Bilhete {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String codigo;
    private Date dataAtivacao;
    private BigDecimal valor;
    private Integer minutos;
    private Veiculo veiculo;

    public Bilhete() {
    }

    public Bilhete(Veiculo veiculo, Integer minutos) {
        Validate.notNull(veiculo);
        Validate.notNull(minutos);
        Validate.isTrue(minutos % 5 == 0);

        this.codigo = RandomStringUtils.random(10);
        this.dataAtivacao = new Date();
        this.minutos = minutos;
        this.veiculo = veiculo;
        this.valor = new BigDecimal(minutos).multiply(new BigDecimal("0.04166666666")).setScale(2, RoundingMode.CEILING);
    }

}
