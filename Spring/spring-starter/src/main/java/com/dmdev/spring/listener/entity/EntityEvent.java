package com.dmdev.spring.listener.entity;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.EventObject;

public class EntityEvent extends ApplicationEvent {

    private AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
