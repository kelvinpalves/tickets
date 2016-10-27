/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * @author cgoettert
 */
public class LoginInterceptor implements Interceptor {

    @Override
    public void destroy() {
        System.out.println("Login interceptor destroy");
    }

    @Override
    public void init() {
        System.out.println("Login interceptor init");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println(invocation.getAction().getClass().getName());
        return invocation.invoke();
    }
    
}
