package dev.caioschultz.EventClean.core.usecases.createrandomidentifier;

import dev.caioschultz.EventClean.core.gateway.EventGateway;

public class CreateRandomIdentifierUseCaseImpl implements CreateRandomIdentifierUseCase{

    private final EventGateway eventGateway;

    public CreateRandomIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public String execute() {
        return eventGateway.createRandomIdentifier();
    }


}
