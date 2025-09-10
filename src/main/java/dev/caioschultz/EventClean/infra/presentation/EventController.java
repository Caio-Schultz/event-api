package dev.caioschultz.EventClean.infra.presentation;
import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.usecases.create.CreateEventCase;
import dev.caioschultz.EventClean.infra.dtos.EventDto;
import dev.caioschultz.EventClean.infra.mapper.EventMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventclean")
public class EventController {

    private final CreateEventCase createEventCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventCase createEventCase, EventMapper eventMapper) {
        this.createEventCase = createEventCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/create")
    public EventDto createEvent(@RequestBody EventDto request){

        Event newEvent = createEventCase.execute(eventMapper.toEntity(request));

        return eventMapper.toDto(newEvent);
    }

    @GetMapping
    public List<EventDto> findAllEvents(){

        return null;

    }

}
