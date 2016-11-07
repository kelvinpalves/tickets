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
public class Veiculo {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String placa;
    private String descricao;
    private Boolean debito;
    private TipoVeiculo tipoVeiculo;

    private Veiculo() {
    }

    public Veiculo(String placa, String descricao, boolean debito, TipoVeiculo tipoVeiculo) {
        this.placa = placa;
        this.descricao = descricao;
        this.tipoVeiculo = tipoVeiculo;
        this.debito = debito;
    }

}
