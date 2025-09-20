package dev.caioschultz.EventClean.core.usecases.findbyid;

import dev.caioschultz.EventClean.core.entities.Event;

public interface FindEventByIdUseCase {

    Event execute(Long id);

}
