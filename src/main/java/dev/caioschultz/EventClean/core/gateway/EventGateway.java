package dev.caioschultz.EventClean.core.gateway;

import dev.caioschultz.EventClean.core.entities.Event;

public interface EventGateway {

    Event createEvent(Event event);
}
