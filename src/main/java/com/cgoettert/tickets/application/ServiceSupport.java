/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cgoettert
 */
public abstract class ServiceSupport implements Feedback {

    private final Map<String, Object> mensagens;

    public ServiceSupport() {
        this.mensagens = new HashMap<>();
    }

    protected final void mensagem(String key, Object value) {
        mensagens.put(key, value);
    }

    @Override
    public final Map<String, Object> getFeedback() {
        return mensagens;
    }

}
