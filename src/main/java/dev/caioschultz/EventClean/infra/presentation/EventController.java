package dev.caioschultz.EventClean.infra.presentation;
import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.usecases.create.CreateEventUseCase;
import dev.caioschultz.EventClean.core.usecases.findall.FindAllEventUseCase;
import dev.caioschultz.EventClean.infra.dtos.EventDto;
import dev.caioschultz.EventClean.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventclean")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventCase;
    private final EventDtoMapper eventMapper;
    private final FindAllEventUseCase findAllEventCase;


    // Retornando com Map o ResponseEntity é possível retornar uma mensagem + um objeto (no caso, o EventoDto criado)
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto request){

        Event newEvent = createEventCase.execute(eventMapper.toDomain(request));
        EventDto createdEvent = eventMapper.toDto(newEvent);

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: " , "Evento salvo com succeso!");
        response.put("Dados do evento: " , createdEvent);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findAllEvents(){

        List<Event> events = findAllEventCase.execute();

        return ResponseEntity.ok(events.stream()
                .map(eventMapper::toDto)
                .toList());
    }

}
