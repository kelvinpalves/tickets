/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.application.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author cgoettert
 */
public abstract class ServiceSupport implements Feedback {

    private static final String TYPE_DATA = "data";
    private static final String TYPE_MESSAGE = "message";
    private static final String EXECUTED = "executed";
    private final Map<String, Object> feeds;

    public ServiceSupport() {
        this.feeds = new HashMap<>();
        this.feeds.put(TYPE_MESSAGE, new ArrayList<>());
        this.feeds.put(TYPE_DATA, new HashMap<>());
        feeds.put(EXECUTED, true);
    }

    protected final void feedData(String key, Object value) {
        feed(TYPE_DATA, key, value);
    }
    
    protected final void feedData(Class clazz, Object value) {
        feed(TYPE_DATA, WordUtils.uncapitalize(clazz.getSimpleName()), value);
    }

    protected final void feedMessage(MessageType type, Object value) {
        if(type == MessageType.ERROR) {
            feeds.put(EXECUTED, false);
        }
        feed(TYPE_MESSAGE, type.toString(), value);
    }

    private void feed(String type, String key, Object value) {
        switch (type) {
            case TYPE_DATA:
                Map map = (Map) feeds.get(TYPE_DATA);
                map.put(key, value);
                break;
            case TYPE_MESSAGE:
                List list = (ArrayList<Object[]>) feeds.get(TYPE_MESSAGE);
                list.add(new Object[]{key, value});
                break;
        }
    }

    @Override
    public Map<String, Object> getFeedback() {
        return feeds;
    }

}
