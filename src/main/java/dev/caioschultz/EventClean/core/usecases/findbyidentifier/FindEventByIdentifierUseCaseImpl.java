package dev.caioschultz.EventClean.core.usecases.findbyidentifier;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase {

    private final EventGateway eventGateway;

    public FindEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findByIdentifier(identifier);
    }
}
