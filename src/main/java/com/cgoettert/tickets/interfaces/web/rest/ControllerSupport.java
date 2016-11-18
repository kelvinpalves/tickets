/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest;

import com.cgoettert.tickets.application.utils.Feedback;

/**
 *
 * @author cgoettert
 */
public abstract class ControllerSupport {

    private final Feedback feedback;

    public ControllerSupport() {
        this.feedback = new Feedback();
    }

    public Feedback getFeedback() {
        return this.feedback;
    }

}
