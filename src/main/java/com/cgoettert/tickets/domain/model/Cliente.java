/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author cgoettert
 */
@Getter
public class Cliente {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private BigDecimal saldo;
    private String senha;
    private List<Telefone> telefones;
    private List<Veiculo> veiculos;
    private List<Compra> compras;
    private List<Bilhete> bilhetes;

    private Cliente() {
    }

    public Cliente(String nome, String cpfCnpj, String email) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.saldo = new BigDecimal("0");
        this.telefones = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.bilhetes = new ArrayList<>();
        this.senha = "1234";
    }

    public void comprarCredito(Integer valor) {

        Validate.notNull(valor);
        Validate.isTrue(valor > 0);

        BigDecimal valorCompra = new BigDecimal(valor);

        saldo = saldo.add(valorCompra);
        compras.add(new Compra(valorCompra));

    }

    public Bilhete ativarBilhete(String placa, Integer minutos) {

        Veiculo veiculo = veiculos.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findAny()
                .orElse(null);
        
        Bilhete bilhete = new Bilhete(veiculo, minutos);

        Validate.isTrue(saldo.compareTo(bilhete.getValor()) != -1);
        
        Compra compra = new Compra(bilhete.getValor().negate());
        
        bilhetes.add(bilhete);
        compras.add(compra);
        
        saldo = saldo.subtract(bilhete.getValor());

        return bilhete;
    }
    
    public Bilhete regularizarBilhete(String codigo) {
//        Bilhete bilhete = bilhetesNaoPagos.stream()
//                .filter(v -> v.getCodigo().equals(codigo))
//                .findAny()
//                .orElse(null);
        Bilhete bilhete = null;

        Validate.notNull(bilhete);
        
        saldo = saldo.subtract(bilhete.getValor());
        
        bilhetes.add(bilhete);
        
        return bilhete;
    }

}
