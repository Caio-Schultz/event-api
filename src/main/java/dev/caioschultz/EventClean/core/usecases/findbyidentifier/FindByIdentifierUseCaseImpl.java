package dev.caioschultz.EventClean.core.usecases.findbyidentifier;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;

public class FindByIdentifierUseCaseImpl implements FindByIdentifierUseCase {

    private final EventGateway eventGateway;

    public FindByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findByIdentifier(identifier);
    }
}
