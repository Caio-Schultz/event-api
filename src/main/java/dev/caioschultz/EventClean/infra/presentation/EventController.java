package dev.caioschultz.EventClean.infra.presentation;
import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.usecases.create.CreateEventCase;
import dev.caioschultz.EventClean.core.usecases.findall.FindAllEventCase;
import dev.caioschultz.EventClean.infra.dtos.EventDto;
import dev.caioschultz.EventClean.infra.mapper.EventDtoMapper;
import dev.caioschultz.EventClean.infra.persistence.EventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventclean")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventCase createEventCase;
    private final EventDtoMapper eventMapper;
    private final FindAllEventCase findAllEventCase;


    @PostMapping("/create")
    public EventDto createEvent(@RequestBody EventDto request){

        Event newEvent = createEventCase.execute(eventMapper.toDomain(request));

        return eventMapper.toDto(newEvent);
    }

    @GetMapping
    public List<EventDto> findAllEvents(){

        List<Event> events = findAllEventCase.execute();

        return events.stream()
                .map(eventMapper::toDto)
                .toList();
    }

}
