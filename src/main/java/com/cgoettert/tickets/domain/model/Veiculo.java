/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

import lombok.Getter;

/**
 *
 * @author cgoettert
 */
@Getter
class Veiculo {
    
    private String placa;
    private String descricao;

    private Veiculo() {
    }

    public Veiculo(String placa, String descricao) {
        this.placa = placa;
        this.descricao = descricao;
    }
    
}
