package dev.caioschultz.EventClean.core.usecases.findbyid;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;

public class FindEventByIdUseCaseImpl implements FindEventByIdUseCase{

    private final EventGateway eventGateway;

    public FindEventByIdUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id) {
        return eventGateway.findById(id);
    }


}
