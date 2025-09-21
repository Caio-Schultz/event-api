package dev.caioschultz.EventClean.core.usecases.delete;

import dev.caioschultz.EventClean.core.gateway.EventGateway;

public class DeleteEventByIdUseCaseImpl implements DeleteEventByIdUseCase{

    private final EventGateway eventGateway;

    public DeleteEventByIdUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(Long id) {
        eventGateway.deleteById(id);
    }

}
