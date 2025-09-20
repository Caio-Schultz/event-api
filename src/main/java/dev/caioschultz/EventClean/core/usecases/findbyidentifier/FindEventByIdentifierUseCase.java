package dev.caioschultz.EventClean.core.usecases.findbyidentifier;

import dev.caioschultz.EventClean.core.entities.Event;

public interface FindEventByIdentifierUseCase {

    Event execute(String identifier);

}
