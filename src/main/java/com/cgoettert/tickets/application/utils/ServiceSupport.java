/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application.utils;

import java.util.Map;

/**
 *
 * @author cgoettert
 */
public abstract class ServiceSupport implements Feed {

    private final Feedback feedback;

    public ServiceSupport() {
        this.feedback = new Feedback();
    }

    public Feedback getFeedback() {
        return this.feedback;
    }

    @Override
    public Map<String, Object> getFeed() {
        return this.feedback.get();
    }

}
