package com.springbootevent.springbootevent.event;

import org.springframework.context.ApplicationEvent;

public class ReservationCreatedEvent extends ApplicationEvent {

    public ReservationCreatedEvent(Object source) {
        super(source);
    }

}
