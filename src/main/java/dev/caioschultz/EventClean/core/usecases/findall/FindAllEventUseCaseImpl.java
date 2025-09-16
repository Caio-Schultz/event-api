package dev.caioschultz.EventClean.core.usecases.findall;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FindAllEventUseCaseImpl implements FindAllEventUseCase {

    private final EventGateway eventGateway;

    public FindAllEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findAllEvents();
    }


}
