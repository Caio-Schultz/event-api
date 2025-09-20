package dev.caioschultz.EventClean.core.gateway;

import dev.caioschultz.EventClean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> findAllEvents();

    Event findByIdentifier(String identifier);

    Event findById(Long id);
}
