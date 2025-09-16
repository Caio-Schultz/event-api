package dev.caioschultz.EventClean.core.usecases.findall;

import dev.caioschultz.EventClean.core.entities.Event;

import java.util.List;

public interface FindAllEventCase {

    List<Event> execute();


}
